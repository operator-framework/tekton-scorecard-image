# tekton-scorecard-image
a SDK Scorecard custom image for the tekton operator

This is an example of an operator-sdk scorecard custom
test image.  It is designed specifically to test the 
tekton pipeline operator.

The included Makefile has targets to build and run the
scorecard tests.

## Build the image

```
make image-build
```

## Setup the Required RBAC for the Tests

```
make installrbac
```

## Run the Scorecard Tests

```
make runtests
```
## Custom Test Notes 

This repo is meant to be an example of how to write some
operator-sdk scorecard custom tests.  In particular, this
example runs some tests for the tekton operator.

The following custom tests are implemented:
| Test Name      | Description |
| ----------- | ----------- |
| operatorrunning      | This is a test that verifies the tekton operator is running, if they are running, the test passes.       |
| tasksuccess   | This test creates a Task and then a TaskRun, it then sees if the TaskRun completes successfully.  The test cleans up the Task and TaskRun resources after it runs.        |

You can see how the scorecard tests are configured by 
examining the config.yaml file in the included sample bundle
directory.  Also, make note of the scorecard command syntax
as found in the Makefile.
