module github.com/operator-framework/tekton-scorecard-image

go 1.13

require (
	github.com/cloudevents/sdk-go/v2 v2.1.0 // indirect
	github.com/operator-framework/api v0.5.1
	github.com/tektoncd/pipeline v0.13.1-0.20200625065359-44f22a067b75
	golang.org/x/tools v0.0.0-20200916195026-c9a70fc28ce3 // indirect
	honnef.co/go/tools v0.0.1-2020.1.5 // indirect
	k8s.io/api v0.20.0
	k8s.io/apimachinery v0.20.0
	k8s.io/client-go v11.0.1-0.20190805182717-6502b5e7b1b5+incompatible
	knative.dev/pkg v0.0.0-20200922164940-4bf40ad82aab // indirect
	sigs.k8s.io/controller-runtime v0.7.0
)

// Knative deps (release-0.18)
replace (
	contrib.go.opencensus.io/exporter/stackdriver => contrib.go.opencensus.io/exporter/stackdriver v0.12.9-0.20191108183826-59d068f8d8ff
	github.com/Azure/azure-sdk-for-go => github.com/Azure/azure-sdk-for-go v38.2.0+incompatible
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v13.4.0+incompatible
)

// Pin k8s deps to v0.18.8
replace (
	k8s.io/api => k8s.io/api v0.20.0
	k8s.io/apiextensions-apiserver => k8s.io/apiextensions-apiserver v0.20.0
	k8s.io/apimachinery => k8s.io/apimachinery v0.20.0
	k8s.io/apiserver => k8s.io/apiserver v0.20.0
	k8s.io/client-go => k8s.io/client-go v0.20.0
	k8s.io/code-generator => k8s.io/code-generator v0.20.0
//	k8s.io/kube-openapi => k8s.io/kube-openapi v0.0.0-20200410145947-bcb3869e6f29
)
