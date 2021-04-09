package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import javautil.manifests.Bundle;
import javautil.scapiv1alpha3.State;
import javautil.scapiv1alpha3.TestResult;
import javautil.scapiv1alpha3.TestStatus;

import java.util.ArrayList;
import java.util.function.Predicate;

import static com.google.common.collect.MoreCollectors.onlyElement;

public class OperatorRunningTest {
    public static final String OperatorRunningTestName = "operatorrunning";

    public static String operatorRunningTest(Bundle bundle) {
        TestResult result = new TestResult();
        result.setName(OperatorRunningTestName);
        result.setState(State.PassState);
        ArrayList<String> errors = new ArrayList<String>();
        ArrayList<String> log = new ArrayList<String>();

        OpenShiftClient osClient;

        try {
            osClient = new DefaultOpenShiftClient();
        } catch (KubernetesClientException e) {
            return makeInstantReturnError(result, log, errors, e, "Error getting OpenShift client");
        }

        String nameSpace = "";
        try {
            Predicate<Namespace> isOSPipeline = n -> n.getMetadata().getName().equals("openshift-pipelines");
            Predicate<Namespace> isTektonPipeline = n -> n.getMetadata().getName().equals("tekton-pipelines");
            Predicate<Namespace> isValidPipeline = isOSPipeline.or(isTektonPipeline);

            nameSpace = osClient.namespaces()
                    .list(new ListOptions())
                    .getItems().stream()
                    .filter(isValidPipeline)
                    .map(n -> n.getMetadata().getName())
                    .collect(onlyElement());
        } catch (Exception e) {
            return makeInstantReturnError(result, log, errors, e, "Trouble finding the pipeline namespace");
        }

        log.add(nameSpace + " is the found namespace");
        // look for a pod with this label: "app=tekton-pipelines-controller"
        ListOptions listOptions = new ListOptions();
        listOptions.setLabelSelector("app=tekton-pipelines-controller");

        Pod pod = osClient.pods().inNamespace(nameSpace)
                    .list(listOptions)
                    .getItems().stream()
                    .collect(onlyElement());

        log.add(pod.getMetadata().getName() + " is the found pod");

        if (pod.getStatus().getPhase().equals("Running")) {
            result.setState(State.PassState);
        } else {
            log.add("Pipeline pod found but not running");
            result.setState(State.FailState);
        }

        result.setLog(log.toString());
        TestStatus testStatus = new TestStatus(java.util.Collections.singletonList(result));
        return wrapAsJSON(testStatus);
    }

    private static String makeInstantReturnError(TestResult result, ArrayList log,
                                                 ArrayList errors, Exception e, String message) {
        errors.add(message);
        errors.add(e.getMessage());
        result.setState(State.FailState);
        result.setErrors(errors);
        result.setLog(log.toString());
        return wrapAsJSON(result);
    }

    private static String wrapAsJSON(Object result) {
        ObjectMapper mapper = new ObjectMapper();
        String resultWrapped = null;
        try {
            resultWrapped = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            System.out.println("Error wrapping test result as JSON: " + e.getMessage());
        }
        return resultWrapped;
    }
}
