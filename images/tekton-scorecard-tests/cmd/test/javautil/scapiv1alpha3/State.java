package javautil.scapiv1alpha3;

import com.fasterxml.jackson.annotation.JsonProperty;

@io.quarkus.runtime.annotations.RegisterForReflection
public enum State {
    @JsonProperty("pass")
    PassState("pass"),
    @JsonProperty("fail")
    FailState("fail"),
    @JsonProperty("error")
    ErrorState("error");

    private String value;

    private State(String value) {
        this.value = value;
    }
}
