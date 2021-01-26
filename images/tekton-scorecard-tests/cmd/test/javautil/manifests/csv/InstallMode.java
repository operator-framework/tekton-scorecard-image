
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "supported",
    "type"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class InstallMode {

    @JsonProperty("supported")
    private Boolean supported;
    @JsonProperty("type")
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public InstallMode() {
    }

    /**
     *
     * @param type
     * @param supported
     */
    public InstallMode(Boolean supported, String type) {
        super();
        this.supported = supported;
        this.type = type;
    }

    @JsonProperty("supported")
    public Boolean getSupported() {
        return supported;
    }

    @JsonProperty("supported")
    public void setSupported(Boolean supported) {
        this.supported = supported;
    }

    public InstallMode withSupported(Boolean supported) {
        this.supported = supported;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public InstallMode withType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InstallMode.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("supported");
        sb.append('=');
        sb.append(((this.supported == null)?"<null>":this.supported));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
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
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.supported == null)? 0 :this.supported.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InstallMode) == false) {
            return false;
        }
        InstallMode rhs = ((InstallMode) other);
        return (((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type)))&&((this.supported == rhs.supported)||((this.supported!= null)&&this.supported.equals(rhs.supported))));
    }

}
