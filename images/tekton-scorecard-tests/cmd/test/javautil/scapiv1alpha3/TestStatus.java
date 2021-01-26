package javautil.scapiv1alpha3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@io.quarkus.runtime.annotations.RegisterForReflection
public class TestStatus {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("results")
    List<TestResult> results;

    public TestStatus(List<TestResult> results) {
        this.results = results;
    }
}
