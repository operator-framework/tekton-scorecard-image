// Copyright 2020 The Operator-SDK Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package tests

import (
	"context"
	"fmt"
	"os"
	"time"

	scapiv1alpha3 "github.com/operator-framework/api/pkg/apis/scorecard/v1alpha3"
	apimanifests "github.com/operator-framework/api/pkg/manifests"
	"github.com/operator-framework/tekton-scorecard-image/internal/util"
	"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1"
	kerrors "k8s.io/apimachinery/pkg/api/errors"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/util/wait"
	clientgoscheme "k8s.io/client-go/kubernetes/scheme"

	"k8s.io/client-go/rest"
)

const (
	TaskTestName = "tasksuccess"
	tname        = "echo-hello-world"
	taskRunName  = "echo-hello-world-task-run"
	testTimeout  = time.Second * 30
)

// Test to see if the taskrun was successful
func TaskRunTest(bundle *apimanifests.Bundle) scapiv1alpha3.TestStatus {
	r := scapiv1alpha3.TestResult{}
	r.Name = TaskTestName
	r.State = scapiv1alpha3.PassState
	r.Errors = make([]string, 0)
	r.Suggestions = make([]string, 0)

	ctx, cancel := context.WithTimeout(context.Background(), testTimeout)
	defer cancel()

	var p v1beta1.Task

	_, config, err := util.GetKubeClient()
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, err.Error())
		return wrapResult(r)
	}

	ns := os.Getenv("SCORECARD_NAMESPACE")
	defer cleanup(config, ns)

	err = v1beta1.AddToScheme(clientgoscheme.Scheme)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, err.Error())
		return wrapResult(r)
	}

	p = v1beta1.Task{}
	p.ObjectMeta.Name = tname
	p.Spec.Steps = make([]v1beta1.Step, 1)
	p.Spec.Steps[0].Container.Name = "echo"
	p.Spec.Steps[0].Container.Image = "ubuntu"
	p.Spec.Steps[0].Container.Command = []string{"echo"}
	p.Spec.Steps[0].Container.Args = []string{"Hello World"}

	taskClient, err := util.NewClient(config, ns)

	_, err = taskClient.Get(tname)
	if err != nil {
		if kerrors.IsNotFound(err) {
			//fmt.Printf("%s is not found\n", tname)
			_, err := taskClient.Create(&p)
			if err != nil {
				r.State = scapiv1alpha3.FailState
				r.Errors = append(r.Errors, err.Error())
				return wrapResult(r)
			}
			//fmt.Printf("%s is created\n", tname)
		} else {
			r.State = scapiv1alpha3.FailState
			r.Errors = append(r.Errors, err.Error())
			return wrapResult(r)
		}
	}

	var taskRun v1beta1.TaskRun
	taskRun.ObjectMeta.Name = taskRunName
	taskRun.Spec.TaskRef = &v1beta1.TaskRef{}
	taskRun.Spec.TaskRef.Name = tname

	tr, err := taskClient.GetTaskRun(taskRunName)
	if err != nil {
		if kerrors.IsNotFound(err) {
			//fmt.Printf("%s is not found\n", taskRunName)
			tr, err = taskClient.CreateTaskRun(&taskRun)
			if err != nil {
				r.State = scapiv1alpha3.FailState
				r.Errors = append(r.Errors, err.Error())
				return wrapResult(r)
			}
			//fmt.Printf("%s is created\n", taskRunName)
		} else {
			r.State = scapiv1alpha3.FailState
			r.Errors = append(r.Errors, err.Error())
			return wrapResult(r)
		}
	}

	err = waitForSuccessfulTest(ctx, tr, taskClient)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "TaskRun was not successful in the timeout period")
		return wrapResult(r)
	}

	return wrapResult(r)
}

func cleanup(config *rest.Config, ns string) {
	taskClient, err := util.NewClient(config, ns)
	if err != nil {
		fmt.Printf("error getting Kube connection %s\n", err.Error())
	}

	// delete the TaskRun
	err = taskClient.DeleteTaskRun(taskRunName, &metav1.DeleteOptions{})
	if err != nil {
		fmt.Printf("error deleting TaskRun %s %s\n", taskRunName, err.Error())
	}

	// delete the Task
	taskClient.Delete(tname, &metav1.DeleteOptions{})
	if err != nil {
		fmt.Printf("error deleting Task %s %s\n", tname, err.Error())
		return
	}
}

func waitForSuccessfulTest(ctx context.Context, p *v1beta1.TaskRun, taskClient *util.TaskClient) (err error) {

	podCheck := wait.ConditionFunc(func() (done bool, err error) {
		var tr *v1beta1.TaskRun

		tr, err = taskClient.GetTaskRun(taskRunName)
		if err != nil {
			return true, fmt.Errorf("error getting TaskRun %s %w", taskRunName, err)
		}

		if tr.IsSuccessful() {
			//fmt.Printf("TaskRun arrives at Successful..\n")
			return true, nil
		}
		//fmt.Printf("still waiting on TaskRun to go to Successful..\n")
		return false, nil
	})

	err = wait.PollImmediateUntil(1*time.Second, podCheck, ctx.Done())
	return err

}
