
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiGroups",
    "resources",
    "verbs",
    "resourceNames"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Rule {

    @JsonProperty("apiGroups")
    private List<String> apiGroups = new ArrayList<String>();
    @JsonProperty("resources")
    private List<String> resources = new ArrayList<String>();
    @JsonProperty("verbs")
    private List<String> verbs = new ArrayList<String>();
    @JsonProperty("resourceNames")
    private List<String> resourceNames = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Rule() {
    }

    /**
     *
     * @param resourceNames
     * @param resources
     * @param verbs
     * @param apiGroups
     */
    public Rule(List<String> apiGroups, List<String> resources, List<String> verbs, List<String> resourceNames) {
        super();
        this.apiGroups = apiGroups;
        this.resources = resources;
        this.verbs = verbs;
        this.resourceNames = resourceNames;
    }

    @JsonProperty("apiGroups")
    public List<String> getApiGroups() {
        return apiGroups;
    }

    @JsonProperty("apiGroups")
    public void setApiGroups(List<String> apiGroups) {
        this.apiGroups = apiGroups;
    }

    public Rule withApiGroups(List<String> apiGroups) {
        this.apiGroups = apiGroups;
        return this;
    }

    @JsonProperty("resources")
    public List<String> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    public Rule withResources(List<String> resources) {
        this.resources = resources;
        return this;
    }

    @JsonProperty("verbs")
    public List<String> getVerbs() {
        return verbs;
    }

    @JsonProperty("verbs")
    public void setVerbs(List<String> verbs) {
        this.verbs = verbs;
    }

    public Rule withVerbs(List<String> verbs) {
        this.verbs = verbs;
        return this;
    }

    @JsonProperty("resourceNames")
    public List<String> getResourceNames() {
        return resourceNames;
    }

    @JsonProperty("resourceNames")
    public void setResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
    }

    public Rule withResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Rule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apiGroups");
        sb.append('=');
        sb.append(((this.apiGroups == null)?"<null>":this.apiGroups));
        sb.append(',');
        sb.append("resources");
        sb.append('=');
        sb.append(((this.resources == null)?"<null>":this.resources));
        sb.append(',');
        sb.append("verbs");
        sb.append('=');
        sb.append(((this.verbs == null)?"<null>":this.verbs));
        sb.append(',');
        sb.append("resourceNames");
        sb.append('=');
        sb.append(((this.resourceNames == null)?"<null>":this.resourceNames));
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
        result = ((result* 31)+((this.resources == null)? 0 :this.resources.hashCode()));
        result = ((result* 31)+((this.resourceNames == null)? 0 :this.resourceNames.hashCode()));
        result = ((result* 31)+((this.verbs == null)? 0 :this.verbs.hashCode()));
        result = ((result* 31)+((this.apiGroups == null)? 0 :this.apiGroups.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rule) == false) {
            return false;
        }
        Rule rhs = ((Rule) other);
        return (((((this.resources == rhs.resources)||((this.resources!= null)&&this.resources.equals(rhs.resources)))&&((this.resourceNames == rhs.resourceNames)||((this.resourceNames!= null)&&this.resourceNames.equals(rhs.resourceNames))))&&((this.verbs == rhs.verbs)||((this.verbs!= null)&&this.verbs.equals(rhs.verbs))))&&((this.apiGroups == rhs.apiGroups)||((this.apiGroups!= null)&&this.apiGroups.equals(rhs.apiGroups))));
    }

}
