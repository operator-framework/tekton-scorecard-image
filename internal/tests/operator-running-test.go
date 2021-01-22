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

	//	"time"

	scapiv1alpha3 "github.com/operator-framework/api/pkg/apis/scorecard/v1alpha3"
	apimanifests "github.com/operator-framework/api/pkg/manifests"
	"github.com/operator-framework/tekton-scorecard-image/internal/util"
	corev1 "k8s.io/api/core/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

const (
	OperatorRunningTestName = "operatorrunning"
)

// Test to see if the tekton operator is in running state
func OperatorRunningTest(bundle *apimanifests.Bundle) scapiv1alpha3.TestStatus {
	r := scapiv1alpha3.TestResult{}
	r.Name = OperatorRunningTestName
	r.State = scapiv1alpha3.PassState
	r.Errors = make([]string, 0)
	r.Suggestions = make([]string, 0)

	//	time.Sleep(20 * time.Second)

	//clientset, config, err := util.GetKubeClient()
	clientset, _, err := util.GetKubeClient()
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "unable to connect to kube")
		return wrapResult(r)
	}

	ns := "tekton-pipelines"

	namespaces, err := clientset.CoreV1().Namespaces().List(context.TODO(), metav1.ListOptions{})
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, fmt.Sprintf("error getting namespaces %s", err.Error()))
		return wrapResult(r)
	}

	for i := 0; i < len(namespaces.Items); i++ {
		n := namespaces.Items[i]
		if n.Name == "openshift-pipelines" {
			ns = "openshift-pipelines"
			break
		}
		if n.Name == "tekton-pipelines" {
			ns = "tekton-pipelines"
			break
		}
	}

	var pods *corev1.PodList
	var p corev1.Pod

	// look for a pod with this label
	//app=tekton-pipelines-controller
	selector := "app=tekton-pipelines-controller"
	listOpts := metav1.ListOptions{LabelSelector: selector}
	pods, err = clientset.CoreV1().Pods(ns).List(context.TODO(), listOpts)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, fmt.Sprintf("error getting pods %s", err.Error()))
		return wrapResult(r)
	}
	if len(pods.Items) == 0 {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "tekton-pipelines-controller pod not found")
		return wrapResult(r)
	}
	p = pods.Items[0]
	if p.Status.Phase != corev1.PodRunning {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "tekton-pipelines-controller pod not running")
		return wrapResult(r)
	}

	// look for a pod with this label
	//app=tekton-pipelines-webhook
	selector = "app=tekton-pipelines-webhook"
	listOpts = metav1.ListOptions{LabelSelector: selector}
	pods, err = clientset.CoreV1().Pods(ns).List(context.TODO(), listOpts)
	if err != nil {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, fmt.Sprintf("error getting pods %s", err.Error()))
		return wrapResult(r)
	}
	if len(pods.Items) == 0 {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "tekton-pipelines-webhook pod not found")
		return wrapResult(r)
	}

	p = pods.Items[0]

	if p.Status.Phase != corev1.PodRunning {
		r.State = scapiv1alpha3.FailState
		r.Errors = append(r.Errors, "tekton-pipelines-webhook pod not running")
		return wrapResult(r)
	}

	return wrapResult(r)
}
