package util

import (
	"context"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/schema"
	"k8s.io/apimachinery/pkg/runtime/serializer"
	"k8s.io/client-go/rest"

	"github.com/tektoncd/pipeline/pkg/apis/pipeline"
	"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1"
)

var SchemeGroupVersion = schema.GroupVersion{Group: pipeline.GroupName, Version: "v1beta1"}

func addKnownTypes(scheme *runtime.Scheme) error {
	scheme.AddKnownTypes(SchemeGroupVersion,
		&v1beta1.Task{},
		&v1beta1.TaskList{},
		&v1beta1.TaskRun{},
		&v1beta1.TaskRunList{},
	)
	metav1.AddToGroupVersion(scheme, SchemeGroupVersion)
	return nil
}

func NewClient(cfg *rest.Config, namespace string) (*TaskClient, error) {
	scheme := runtime.NewScheme()
	SchemeBuilder := runtime.NewSchemeBuilder(addKnownTypes)
	if err := SchemeBuilder.AddToScheme(scheme); err != nil {
		return nil, err
	}
	config := *cfg
	config.GroupVersion = &SchemeGroupVersion
	config.APIPath = "/apis"
	config.ContentType = runtime.ContentTypeJSON
	config.NegotiatedSerializer = serializer.WithoutConversionCodecFactory{CodecFactory: serializer.NewCodecFactory(scheme)}
	client, err := rest.RESTClientFor(&config)
	if err != nil {
		return nil, err
	}
	return &TaskClient{restClient: client, ns: namespace}, nil
}

type TaskClient struct {
	restClient rest.Interface
	ns         string
}

func (c *TaskClient) Get(name string) (*v1beta1.Task, error) {
	result := &v1beta1.Task{}
	err := c.restClient.Get().
		Namespace(c.ns).Resource("tasks").
		Name(name).Do(context.TODO()).Into(result)
	return result, err
}
func (c *TaskClient) Create(obj *v1beta1.Task) (*v1beta1.Task, error) {
	result := &v1beta1.Task{}
	err := c.restClient.Post().
		Namespace(c.ns).Resource("tasks").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}
func (c *TaskClient) Update(obj *v1beta1.Task) (*v1beta1.Task, error) {
	result := &v1beta1.Task{}
	err := c.restClient.Put().
		Namespace(c.ns).Resource("tasks").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}

func (c *TaskClient) Delete(name string, options *metav1.DeleteOptions) error {
	return c.restClient.Delete().
		Namespace(c.ns).Resource("tasks").
		Name(name).Body(options).Do(context.TODO()).
		Error()
}

func (c *TaskClient) GetTaskRun(name string) (*v1beta1.TaskRun, error) {
	result := &v1beta1.TaskRun{}
	err := c.restClient.Get().
		Namespace(c.ns).Resource("taskruns").
		Name(name).Do(context.TODO()).Into(result)
	return result, err
}
func (c *TaskClient) CreateTaskRun(obj *v1beta1.TaskRun) (*v1beta1.TaskRun, error) {
	result := &v1beta1.TaskRun{}
	err := c.restClient.Post().
		Namespace(c.ns).Resource("taskruns").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}
func (c *TaskClient) UpdateTaskRun(obj *v1beta1.TaskRun) (*v1beta1.TaskRun, error) {
	result := &v1beta1.TaskRun{}
	err := c.restClient.Put().
		Namespace(c.ns).Resource("taskruns").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}

func (c *TaskClient) DeleteTaskRun(name string, options *metav1.DeleteOptions) error {
	return c.restClient.Delete().
		Namespace(c.ns).Resource("taskruns").
		Name(name).Body(options).Do(context.TODO()).
		Error()
}
