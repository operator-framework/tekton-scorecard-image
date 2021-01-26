
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containers",
    "serviceAccountName"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Spec__3 {

    @JsonProperty("containers")
    private List<Container> containers = new ArrayList<Container>();
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Spec__3() {
    }

    /**
     *
     * @param serviceAccountName
     * @param containers
     */
    public Spec__3(List<Container> containers, String serviceAccountName) {
        super();
        this.containers = containers;
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("containers")
    public List<Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public Spec__3 withContainers(List<Container> containers) {
        this.containers = containers;
        return this;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    public Spec__3 withServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spec__3 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("containers");
        sb.append('=');
        sb.append(((this.containers == null)?"<null>":this.containers));
        sb.append(',');
        sb.append("serviceAccountName");
        sb.append('=');
        sb.append(((this.serviceAccountName == null)?"<null>":this.serviceAccountName));
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
        result = ((result* 31)+((this.containers == null)? 0 :this.containers.hashCode()));
        result = ((result* 31)+((this.serviceAccountName == null)? 0 :this.serviceAccountName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec__3) == false) {
            return false;
        }
        Spec__3 rhs = ((Spec__3) other);
        return (((this.containers == rhs.containers)||((this.containers!= null)&&this.containers.equals(rhs.containers)))&&((this.serviceAccountName == rhs.serviceAccountName)||((this.serviceAccountName!= null)&&this.serviceAccountName.equals(rhs.serviceAccountName))));
    }

}
