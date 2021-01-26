
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deployments",
    "permissions"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Spec__1 {

    @JsonProperty("deployments")
    private List<Deployment> deployments = new ArrayList<Deployment>();
    @JsonProperty("permissions")
    private List<Permission> permissions = new ArrayList<Permission>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Spec__1() {
    }

    /**
     *
     * @param deployments
     * @param permissions
     */
    public Spec__1(List<Deployment> deployments, List<Permission> permissions) {
        super();
        this.deployments = deployments;
        this.permissions = permissions;
    }

    @JsonProperty("deployments")
    public List<Deployment> getDeployments() {
        return deployments;
    }

    @JsonProperty("deployments")
    public void setDeployments(List<Deployment> deployments) {
        this.deployments = deployments;
    }

    public Spec__1 withDeployments(List<Deployment> deployments) {
        this.deployments = deployments;
        return this;
    }

    @JsonProperty("permissions")
    public List<Permission> getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Spec__1 withPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spec__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deployments");
        sb.append('=');
        sb.append(((this.deployments == null)?"<null>":this.deployments));
        sb.append(',');
        sb.append("permissions");
        sb.append('=');
        sb.append(((this.permissions == null)?"<null>":this.permissions));
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
        result = ((result* 31)+((this.deployments == null)? 0 :this.deployments.hashCode()));
        result = ((result* 31)+((this.permissions == null)? 0 :this.permissions.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec__1) == false) {
            return false;
        }
        Spec__1 rhs = ((Spec__1) other);
        return (((this.deployments == rhs.deployments)||((this.deployments!= null)&&this.deployments.equals(rhs.deployments)))&&((this.permissions == rhs.permissions)||((this.permissions!= null)&&this.permissions.equals(rhs.permissions))));
    }

}
