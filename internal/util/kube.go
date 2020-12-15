package util

import (
	"k8s.io/client-go/kubernetes"
	"k8s.io/client-go/rest"
	ctrl "sigs.k8s.io/controller-runtime"
)

// GetKubeClient will get a kubernetes client from the following sources:
// - a path to the kubeconfig file passed on the command line (--kubeconfig)
// - an environment variable that specifies the path (export KUBECONFIG)
// - the user's $HOME/.kube/config file
// - in-cluster connection for when the sdk is run within a cluster instead of
//   the command line
func GetKubeClient() (client *kubernetes.Clientset, config *rest.Config, err error) {

	config, err = ctrl.GetConfig()
	if err != nil {
		return client, config, err
	}

	// create the clientset
	clientset, err := kubernetes.NewForConfig(config)
	if err != nil {
		return client, config, err
	}

	return clientset, config, err
}
