package javautil.manifests;

import com.fasterxml.jackson.annotation.JsonProperty;

@io.quarkus.runtime.annotations.RegisterForReflection
public class Dependency {
    @JsonProperty("type") String depType;
    @JsonProperty("value") String depValue;
}
