
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "kind",
    "name",
    "version",
    "specDescriptors",
    "resources",
    "statusDescriptors"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Owned {

    @JsonProperty("description")
    private String description;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private String version;
    @JsonProperty("specDescriptors")
    private List<SpecDescriptor> specDescriptors = new ArrayList<SpecDescriptor>();
    @JsonProperty("resources")
    private List<Resource> resources = new ArrayList<Resource>();
    @JsonProperty("statusDescriptors")
    private List<StatusDescriptor> statusDescriptors = new ArrayList<StatusDescriptor>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Owned() {
    }

    /**
     *
     * @param specDescriptors
     * @param kind
     * @param name
     * @param description
     * @param resources
     * @param statusDescriptors
     * @param version
     */
    public Owned(String description, String kind, String name, String version, List<SpecDescriptor> specDescriptors, List<Resource> resources, List<StatusDescriptor> statusDescriptors) {
        super();
        this.description = description;
        this.kind = kind;
        this.name = name;
        this.version = version;
        this.specDescriptors = specDescriptors;
        this.resources = resources;
        this.statusDescriptors = statusDescriptors;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Owned withDescription(String description) {
        this.description = description;
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

    public Owned withKind(String kind) {
        this.kind = kind;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Owned withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Owned withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("specDescriptors")
    public List<SpecDescriptor> getSpecDescriptors() {
        return specDescriptors;
    }

    @JsonProperty("specDescriptors")
    public void setSpecDescriptors(List<SpecDescriptor> specDescriptors) {
        this.specDescriptors = specDescriptors;
    }

    public Owned withSpecDescriptors(List<SpecDescriptor> specDescriptors) {
        this.specDescriptors = specDescriptors;
        return this;
    }

    @JsonProperty("resources")
    public List<Resource> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Owned withResources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }

    @JsonProperty("statusDescriptors")
    public List<StatusDescriptor> getStatusDescriptors() {
        return statusDescriptors;
    }

    @JsonProperty("statusDescriptors")
    public void setStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
        this.statusDescriptors = statusDescriptors;
    }

    public Owned withStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
        this.statusDescriptors = statusDescriptors;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Owned.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("specDescriptors");
        sb.append('=');
        sb.append(((this.specDescriptors == null)?"<null>":this.specDescriptors));
        sb.append(',');
        sb.append("resources");
        sb.append('=');
        sb.append(((this.resources == null)?"<null>":this.resources));
        sb.append(',');
        sb.append("statusDescriptors");
        sb.append('=');
        sb.append(((this.statusDescriptors == null)?"<null>":this.statusDescriptors));
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
        result = ((result* 31)+((this.specDescriptors == null)? 0 :this.specDescriptors.hashCode()));
        result = ((result* 31)+((this.kind == null)? 0 :this.kind.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.resources == null)? 0 :this.resources.hashCode()));
        result = ((result* 31)+((this.statusDescriptors == null)? 0 :this.statusDescriptors.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Owned) == false) {
            return false;
        }
        Owned rhs = ((Owned) other);
        return ((((((((this.specDescriptors == rhs.specDescriptors)||((this.specDescriptors!= null)&&this.specDescriptors.equals(rhs.specDescriptors)))&&((this.kind == rhs.kind)||((this.kind!= null)&&this.kind.equals(rhs.kind))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.resources == rhs.resources)||((this.resources!= null)&&this.resources.equals(rhs.resources))))&&((this.statusDescriptors == rhs.statusDescriptors)||((this.statusDescriptors!= null)&&this.statusDescriptors.equals(rhs.statusDescriptors))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
