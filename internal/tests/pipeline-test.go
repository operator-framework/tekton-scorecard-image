// Copyright 2021 The Operator-SDK Authors
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
	PipelineRunTestName = "pipelinerunsuccess"
	pipelineName        = "hello-world-pipeline"
	pipelineRunName     = "hello-world-pipelinerun"
)

// Test to see if the PipelineRun was successful
func PipelineRunTest(bundle *apimanifests.Bundle) scapiv1alpha3.TestStatus {

	// initialize the scorecard test result
	r := scapiv1alpha3.TestResult{}
	r.Name = PipelineRunTestName
	r.State = scapiv1alpha3.PassState
	r.Errors = make([]string, 0)
	r.Suggestions = make([]string, 0)

	// setup the timeout context
	ctx, cancel := context.WithTimeout(context.Background(), testTimeout)
	defer cancel()

	// get a connection to the k8s API
	_, config, err := util.GetKubeClient()
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, err.Error())
		return wrapResult(r)
	}

	ns := os.Getenv("SCORECARD_NAMESPACE")

	// make sure test resources are cleaned up first
	cleanupPipeline(config, ns)

	// setup the cleanup of resources when this test completes
	defer cleanupPipeline(config, ns)

	err = v1beta1.AddToScheme(clientgoscheme.Scheme)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, err.Error())
		return wrapResult(r)
	}

	// get the pipeline and task k8s clients
	pipelineClient, err := util.NewPipelineClient(config, ns)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, err.Error())
		return wrapResult(r)
	}
	taskClient, err := util.NewClient(config, ns)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, err.Error())
		return wrapResult(r)
	}

	// ensure we have a task created name echo-hello-world
	// we'll use it later for our pipeline

	_, err = taskClient.Get("echo-hello-world")
	if err != nil {
		if kerrors.IsNotFound(err) {
			//fmt.Printf("%s is not found\n", tname)
			t := v1beta1.Task{}
			t.ObjectMeta.Name = "echo-hello-world"
			t.Spec.Steps = make([]v1beta1.Step, 1)
			t.Spec.Steps[0].Container.Name = "echo"
			t.Spec.Steps[0].Container.Image = "ubuntu"
			t.Spec.Steps[0].Container.Command = []string{"echo"}
			t.Spec.Steps[0].Container.Args = []string{"Hello World"}

			_, err := taskClient.Create(&t)
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

	_, err = pipelineClient.Get(pipelineName)
	if err != nil {
		if kerrors.IsNotFound(err) {
			// make sure the Pipeline hello-world-pipeline is created
			p := v1beta1.Pipeline{}
			p.ObjectMeta.Name = pipelineName
			p.Spec.Tasks = make([]v1beta1.PipelineTask, 1)
			p.Spec.Tasks[0].Name = "run-hello-world-task"
			p.Spec.Tasks[0].TaskRef.Name = "echo-hello-world"
			_, err := pipelineClient.Create(&p)
			if err != nil {
				r.State = scapiv1alpha3.FailState
				r.Errors = append(r.Errors, err.Error())
				return wrapResult(r)
			}
		} else {
			r.State = scapiv1alpha3.FailState
			r.Errors = append(r.Errors, err.Error())
			return wrapResult(r)
		}
	}

	// create the PipelineRun

	pr := v1beta1.PipelineRun{}
	_, err = pipelineClient.GetPipelineRun(pipelineRunName)
	if err != nil {
		if kerrors.IsNotFound(err) {
			//fmt.Printf("%s is not found\n", pipelineRunName)
			pr.ObjectMeta.Name = pipelineRunName
			pr.Spec.PipelineRef = &v1beta1.PipelineRef{}
			pr.Spec.PipelineRef.Name = pipelineName
			_, err = pipelineClient.CreatePipelineRun(&pr)
			if err != nil {
				r.State = scapiv1alpha3.FailState
				r.Errors = append(r.Errors, err.Error())
				return wrapResult(r)
			}
			//fmt.Printf("%s is created\n", pipelineRunName)
		} else {
			r.State = scapiv1alpha3.FailState
			r.Errors = append(r.Errors, err.Error())
			return wrapResult(r)
		}
	}

	err = waitForSuccessfulPipelineRunTest(ctx, &pr, pipelineClient)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "PipelineRun was not successful in the timeout period")
		return wrapResult(r)
	}

	return wrapResult(r)
}

func cleanupPipeline(config *rest.Config, ns string) {
	pipelineClient, err := util.NewPipelineClient(config, ns)
	if err != nil {
		fmt.Printf("error getting Kube connection %s\n", err.Error())
	}

	// delete the PipelineRun
	err = pipelineClient.DeletePipelineRun(pipelineRunName, &metav1.DeleteOptions{})
	if err != nil {
		fmt.Printf("error deleting PipelineRun %s %s\n", pipelineRunName, err.Error())
	}

	// delete the Pipeline
	pipelineClient.Delete(tname, &metav1.DeleteOptions{})
	if err != nil {
		fmt.Printf("error deleting Pipeline %s %s\n", pipelineName, err.Error())
		return
	}
}

func waitForSuccessfulPipelineRunTest(ctx context.Context, p *v1beta1.PipelineRun, pipelineClient *util.PipelineClient) (err error) {

	podCheck := wait.ConditionFunc(func() (done bool, err error) {
		var pr *v1beta1.PipelineRun

		pr, err = pipelineClient.GetPipelineRun(pipelineRunName)
		if err != nil {
			return true, fmt.Errorf("error getting PipelineRun %s %w", pipelineRunName, err)
		}

		if pr.IsDone() {
			//fmt.Printf("PipelineRun arrives at Done..\n")
			return true, nil
		}
		//fmt.Printf("still waiting on PipelineRun to go to Successful..\n")
		return false, nil
	})

	err = wait.PollImmediateUntil(1*time.Second, podCheck, ctx.Done())
	return err

}
