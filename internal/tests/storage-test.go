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
	"io/ioutil"
	"os"

	scapiv1alpha3 "github.com/operator-framework/api/pkg/apis/scorecard/v1alpha3"
	apimanifests "github.com/operator-framework/api/pkg/manifests"
)

const (
	StorageTestName = "storagetest"
)

// Define any operator specific custom tests here.
// CustomTest1 and CustomTest2 are example test functions. Relevant operator specific
// test logic is to be implemented in similarly.

func StorageTest(bundle *apimanifests.Bundle) scapiv1alpha3.TestStatus {
	r := scapiv1alpha3.TestResult{}
	r.Name = StorageTestName
	r.State = scapiv1alpha3.PassState
	r.Errors = make([]string, 0)
	r.Suggestions = make([]string, 0)

	// the expected mount point for storage is /test-output
	// this test will see if we can write some file to that directory
	// if storage is configured correctly this test should pass

	if _, err := os.Stat("/test-output"); os.IsNotExist(err) {
		r.Errors = append(r.Errors, "/test-output directory does not exist")
		r.State = scapiv1alpha3.FailState
		r.Suggestions = append(r.Suggestions, "be sure to configure storage")
		return wrapResult(r)
	}

	d1 := []byte("hello\ngo\n")
	err := ioutil.WriteFile("/test-output/some-test-output", d1, 0644)
	if err != nil {
		r.Errors = append(r.Errors, "error writing test output "+err.Error())
		r.State = scapiv1alpha3.FailState
		return wrapResult(r)
	}
	return wrapResult(r)
}
