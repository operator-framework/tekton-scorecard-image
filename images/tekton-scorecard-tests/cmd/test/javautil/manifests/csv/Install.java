
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "spec",
    "strategy"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Install {

    @JsonProperty("spec")
    private Spec__1 spec;
    @JsonProperty("strategy")
    private String strategy;

    /**
     * No args constructor for use in serialization
     *
     */
    public Install() {
    }

    /**
     *
     * @param strategy
     * @param spec
     */
    public Install(Spec__1 spec, String strategy) {
        super();
        this.spec = spec;
        this.strategy = strategy;
    }

    @JsonProperty("spec")
    public Spec__1 getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Spec__1 spec) {
        this.spec = spec;
    }

    public Install withSpec(Spec__1 spec) {
        this.spec = spec;
        return this;
    }

    @JsonProperty("strategy")
    public String getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Install withStrategy(String strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Install.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("spec");
        sb.append('=');
        sb.append(((this.spec == null)?"<null>":this.spec));
        sb.append(',');
        sb.append("strategy");
        sb.append('=');
        sb.append(((this.strategy == null)?"<null>":this.strategy));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.strategy == null)? 0 :this.strategy.hashCode()));
        result = ((result* 31)+((this.spec == null)? 0 :this.spec.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Install) == false) {
            return false;
        }
        Install rhs = ((Install) other);
        return (((this.strategy == rhs.strategy)||((this.strategy!= null)&&this.strategy.equals(rhs.strategy)))&&((this.spec == rhs.spec)||((this.spec!= null)&&this.spec.equals(rhs.spec))));
    }

}
