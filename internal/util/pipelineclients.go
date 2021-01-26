package util

import (
	"context"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/serializer"
	"k8s.io/client-go/rest"

	"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1"
)

func NewPipelineClient(cfg *rest.Config, namespace string) (*PipelineClient, error) {
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
	return &PipelineClient{restClient: client, ns: namespace}, nil
}

type PipelineClient struct {
	restClient rest.Interface
	ns         string
}

func (c *PipelineClient) Get(name string) (*v1beta1.Pipeline, error) {
	result := &v1beta1.Pipeline{}
	err := c.restClient.Get().
		Namespace(c.ns).Resource("pipelines").
		Name(name).Do(context.TODO()).Into(result)
	return result, err
}
func (c *PipelineClient) Create(obj *v1beta1.Pipeline) (*v1beta1.Pipeline, error) {
	result := &v1beta1.Pipeline{}
	err := c.restClient.Post().
		Namespace(c.ns).Resource("pipelines").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}
func (c *PipelineClient) Update(obj *v1beta1.Pipeline) (*v1beta1.Pipeline, error) {
	result := &v1beta1.Pipeline{}
	err := c.restClient.Put().
		Namespace(c.ns).Resource("pipelines").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}

func (c *PipelineClient) Delete(name string, options *metav1.DeleteOptions) error {
	return c.restClient.Delete().
		Namespace(c.ns).Resource("pipelines").
		Name(name).Body(options).Do(context.TODO()).
		Error()
}

func (c *PipelineClient) GetPipelineRun(name string) (*v1beta1.PipelineRun, error) {
	result := &v1beta1.PipelineRun{}
	err := c.restClient.Get().
		Namespace(c.ns).Resource("pipelineruns").
		Name(name).Do(context.TODO()).Into(result)
	return result, err
}
func (c *PipelineClient) CreatePipelineRun(obj *v1beta1.PipelineRun) (*v1beta1.PipelineRun, error) {
	result := &v1beta1.PipelineRun{}
	err := c.restClient.Post().
		Namespace(c.ns).Resource("pipelineruns").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}
func (c *PipelineClient) UpdatePipelineRun(obj *v1beta1.PipelineRun) (*v1beta1.PipelineRun, error) {
	result := &v1beta1.PipelineRun{}
	err := c.restClient.Put().
		Namespace(c.ns).Resource("pipelineruns").
		Body(obj).Do(context.TODO()).Into(result)
	return result, err
}

func (c *PipelineClient) DeletePipelineRun(name string, options *metav1.DeleteOptions) error {
	return c.restClient.Delete().
		Namespace(c.ns).Resource("pipelineruns").
		Name(name).Body(options).Do(context.TODO()).
		Error()
}
