import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class Main{
    public static void main (String[] args) {
        var entrypoint = args[0];
        System.out.println(entrypoint);
    }
}