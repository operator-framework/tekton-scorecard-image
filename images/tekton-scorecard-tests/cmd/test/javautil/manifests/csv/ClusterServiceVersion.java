
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class ClusterServiceVersion {

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("spec")
    private Spec spec;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClusterServiceVersion() {
    }

    /**
     *
     * @param metadata
     * @param apiVersion
     * @param kind
     * @param spec
     */
    public ClusterServiceVersion(String apiVersion, String kind, Metadata metadata, Spec spec) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public ClusterServiceVersion withApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    public ClusterServiceVersion withKind(String kind) {
        this.kind = kind;
        return this;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ClusterServiceVersion withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("spec")
    public Spec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public ClusterServiceVersion withSpec(Spec spec) {
        this.spec = spec;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClusterServiceVersion.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apiVersion");
        sb.append('=');
        sb.append(((this.apiVersion == null)?"<null>":this.apiVersion));
        sb.append(',');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("metadata");
        sb.append('=');
        sb.append(((this.metadata == null)?"<null>":this.metadata));
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
        result = ((result* 31)+((this.metadata == null)? 0 :this.metadata.hashCode()));
        result = ((result* 31)+((this.apiVersion == null)? 0 :this.apiVersion.hashCode()));
        result = ((result* 31)+((this.kind == null)? 0 :this.kind.hashCode()));
        result = ((result* 31)+((this.spec == null)? 0 :this.spec.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClusterServiceVersion) == false) {
            return false;
        }
        ClusterServiceVersion rhs = ((ClusterServiceVersion) other);
        return (((((this.metadata == rhs.metadata)||((this.metadata!= null)&&this.metadata.equals(rhs.metadata)))&&((this.apiVersion == rhs.apiVersion)||((this.apiVersion!= null)&&this.apiVersion.equals(rhs.apiVersion))))&&((this.kind == rhs.kind)||((this.kind!= null)&&this.kind.equals(rhs.kind))))&&((this.spec == rhs.spec)||((this.spec!= null)&&this.spec.equals(rhs.spec))));
    }

}
