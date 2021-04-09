package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javautil.manifests.Bundle;
import javautil.scapiv1alpha3.State;
import javautil.scapiv1alpha3.TestResult;
import javautil.scapiv1alpha3.TestStatus;

public class Tests {
    public static final String CustomTest1Name = "customtest1";
    public static final String CustomTest2Name = "customtest2";

    public static String customTest1(Bundle bundle) {
        TestResult result = new TestResult();
        result.setName(CustomTest1Name);
        result.setState(State.PassState);
        TestStatus testStatus = new TestStatus(java.util.Collections.singletonList(result));
        return wrapAsJSON(testStatus);
    }

    public static String customTest2(Bundle bundle) {
        TestResult result = new TestResult();
        result.setName(CustomTest2Name);
        result.setState(State.PassState);
        result.setSuggestions(
                java.util.Collections.singletonList("CSV Name: " + bundle.getCSV().getMetadata().getName()));
        TestStatus testStatus = new TestStatus(java.util.Collections.singletonList(result));
        return wrapAsJSON(testStatus);
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
