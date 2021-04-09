
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "spec"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Deployment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("spec")
    private Spec__2 spec;

    /**
     * No args constructor for use in serialization
     *
     */
    public Deployment() {
    }

    /**
     *
     * @param name
     * @param spec
     */
    public Deployment(String name, Spec__2 spec) {
        super();
        this.name = name;
        this.spec = spec;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Deployment withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("spec")
    public Spec__2 getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Spec__2 spec) {
        this.spec = spec;
    }

    public Deployment withSpec(Spec__2 spec) {
        this.spec = spec;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Deployment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("spec");
        sb.append('=');
        sb.append(((this.spec == null)?"<null>":this.spec));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.spec == null)? 0 :this.spec.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Deployment) == false) {
            return false;
        }
        Deployment rhs = ((Deployment) other);
        return (((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.spec == rhs.spec)||((this.spec!= null)&&this.spec.equals(rhs.spec))));
    }

}
