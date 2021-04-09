
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "displayName",
    "path",
    "x-descriptors"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class SpecDescriptor {

    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("path")
    private String path;
    @JsonProperty("x-descriptors")
    private List<String> xDescriptors = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     *
     */
    public SpecDescriptor() {
    }

    /**
     *
     * @param path
     * @param displayName
     * @param xDescriptors
     * @param description
     */
    public SpecDescriptor(String description, String displayName, String path, List<String> xDescriptors) {
        super();
        this.description = description;
        this.displayName = displayName;
        this.path = path;
        this.xDescriptors = xDescriptors;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public SpecDescriptor withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public SpecDescriptor withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    public SpecDescriptor withPath(String path) {
        this.path = path;
        return this;
    }

    @JsonProperty("x-descriptors")
    public List<String> getxDescriptors() {
        return xDescriptors;
    }

    @JsonProperty("x-descriptors")
    public void setxDescriptors(List<String> xDescriptors) {
        this.xDescriptors = xDescriptors;
    }

    public SpecDescriptor withxDescriptors(List<String> xDescriptors) {
        this.xDescriptors = xDescriptors;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecDescriptor.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
        sb.append(',');
        sb.append("xDescriptors");
        sb.append('=');
        sb.append(((this.xDescriptors == null)?"<null>":this.xDescriptors));
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
        result = ((result* 31)+((this.xDescriptors == null)? 0 :this.xDescriptors.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.path == null)? 0 :this.path.hashCode()));
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpecDescriptor) == false) {
            return false;
        }
        SpecDescriptor rhs = ((SpecDescriptor) other);
        return (((((this.xDescriptors == rhs.xDescriptors)||((this.xDescriptors!= null)&&this.xDescriptors.equals(rhs.xDescriptors)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.path == rhs.path)||((this.path!= null)&&this.path.equals(rhs.path))))&&((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName))));
    }

}
