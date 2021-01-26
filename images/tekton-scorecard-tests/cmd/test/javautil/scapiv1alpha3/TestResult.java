package javautil.scapiv1alpha3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@io.quarkus.runtime.annotations.RegisterForReflection
public class TestResult {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("name")
    String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("log")
    String log;

    @JsonProperty("state")
    State state;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errors")
    List<String> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("suggestions")
    List<String> suggestions;

    public void setName(String name) {
        this.name = name;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public TestResult() {
    }
}
