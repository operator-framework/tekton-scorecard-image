IMAGE = quay.io/operator-framework/tekton-scorecard-image
SHELL = /bin/bash
# set Go builds flags for cross-compilation in case build system is non-Linux
GO_BUILD_FLAGS = GOOS=linux GOARCH=amd64

all: build

installrbac: ## run only one time to configure rbac for tests
	kubectl apply -f rbac/
clean: ## Clean up the build artifacts
	rm -f images/tekton-scorecard-tests/tekton-scorecard-tests

build:
	$(GO_BUILD_FLAGS) go build internal/tests/tests.go
image-build: ## Running `make image-build` from the project root of this example test function will build docker test image.
	go build -o images/tekton-scorecard-tests/tekton-scorecard-tests images/tekton-scorecard-tests/cmd/test/main.go
	cd images/tekton-scorecard-tests && docker build -t $(IMAGE):dev .
runtests: ## run the scorecard tests
	#operator-sdk scorecard ./bundle --selector=suite=tekton --service-account=tekton-operator-tests --namespace=default
	#operator-sdk scorecard ./bundle --selector='suite=tekton,test=pipelinerunsuccess' --service-account=tekton-operator-tests --namespace=default --skip-cleanup
	operator-sdk scorecard ./bundle --selector='suite=tekton' --service-account=tekton-operator-tests --namespace=default --skip-cleanup
