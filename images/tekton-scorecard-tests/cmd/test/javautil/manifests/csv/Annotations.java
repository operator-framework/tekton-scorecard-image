
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alm-examples",
    "capabilities"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Annotations {

    @JsonProperty("alm-examples")
    private String almExamples;
    @JsonProperty("capabilities")
    private String capabilities;

    /**
     * No args constructor for use in serialization
     *
     */
    public Annotations() {
    }

    /**
     *
     * @param capabilities
     * @param almExamples
     */
    public Annotations(String almExamples, String capabilities) {
        super();
        this.almExamples = almExamples;
        this.capabilities = capabilities;
    }

    @JsonProperty("alm-examples")
    public String getAlmExamples() {
        return almExamples;
    }

    @JsonProperty("alm-examples")
    public void setAlmExamples(String almExamples) {
        this.almExamples = almExamples;
    }

    public Annotations withAlmExamples(String almExamples) {
        this.almExamples = almExamples;
        return this;
    }

    @JsonProperty("capabilities")
    public String getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public Annotations withCapabilities(String capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Annotations.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("almExamples");
        sb.append('=');
        sb.append(((this.almExamples == null)?"<null>":this.almExamples));
        sb.append(',');
        sb.append("capabilities");
        sb.append('=');
        sb.append(((this.capabilities == null)?"<null>":this.capabilities));
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
        result = ((result* 31)+((this.almExamples == null)? 0 :this.almExamples.hashCode()));
        result = ((result* 31)+((this.capabilities == null)? 0 :this.capabilities.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Annotations) == false) {
            return false;
        }
        Annotations rhs = ((Annotations) other);
        return (((this.almExamples == rhs.almExamples)||((this.almExamples!= null)&&this.almExamples.equals(rhs.almExamples)))&&((this.capabilities == rhs.capabilities)||((this.capabilities!= null)&&this.capabilities.equals(rhs.capabilities))));
    }

}
