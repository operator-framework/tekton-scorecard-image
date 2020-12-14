IMAGE = quay.io/operator-framework/tekton-scorecard-image
SHELL = /bin/bash

all: build

clean: ## Clean up the build artifacts
	rm -f images/tekton-scorecard-tests/tekton-scorecard-tests

build:
	go build internal/tests/tests.go
image-build: ## Running `make image-build` from the project root of this example test function will build docker test image.
	go build -o images/tekton-scorecard-tests/tekton-scorecard-tests images/tekton-scorecard-tests/cmd/test/main.go
	cd images/tekton-scorecard-tests && docker build -t $(IMAGE):dev .
