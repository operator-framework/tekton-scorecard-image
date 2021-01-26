IMAGE = quay.io/btofel/tekton-scorecard-image
SHELL = /bin/bash
MVN := $(shell command -v mvn 2> /dev/null)
# set Go builds flags for cross-compilation in case build system is non-Linux
GO_BUILD_FLAGS = GOOS=linux GOARCH=amd64

all: build build-java-native

tag-update:
	./tag-update.pl

docker-push:
	docker push default-route-openshift-image-registry.apps-crc.testing/default/tekton-scorecard-image:latest11

installrbac: ## run only one time to configure rbac for tests
	kubectl apply -f rbac/

clean: ## Clean up the build artifacts
	rm -f images/tekton-scorecard-tests/tekton-scorecard-tests
ifneq (, $(MVN))
	mvn clean
endif

build:
	$(GO_BUILD_FLAGS) go build internal/tests/tests.go

build-java-native:
ifneq (, $(MVN))
	mvn package -Pnative -Dquarkus.native.container-build=true
	cp target/tekton-scorecard-image-*-runner images/tekton-scorecard-tests/tekton-scorecard-tests
endif

build-java:
ifneq (, $(MVN))
	mvn package
	cp target/tekton-scorecard-image-*-runner images/tekton-scorecard-tests/tekton-scorecard-tests
endif

image-build: ## Running `make image-build` from the project root of this example test function will build docker test image.
	$(GO_BUILD_FLAGS) go build -o images/tekton-scorecard-tests/tekton-scorecard-tests images/tekton-scorecard-tests/cmd/test/main.go
	cd images/tekton-scorecard-tests && docker build -t $(IMAGE):latest11 .

image-build-java: build-java-native ## Running `make image-build-java` from the project root of this example test function will build docker test image with Java native image.
	cd images/tekton-scorecard-tests && docker build -t $(IMAGE):latest11 .

runtests: ## run the scorecard tests
	#operator-sdk scorecard ./bundle --selector=suite=tekton --service-account=tekton-operator-tests --namespace=default
	#operator-sdk scorecard ./bundle --selector='suite=tekton,test=pipelinerunsuccess' --service-account=tekton-operator-tests --namespace=default --skip-cleanup
	operator-sdk scorecard ./bundle --selector='suite=tekton' --service-account=tekton-operator-tests --namespace=default --skip-cleanup
