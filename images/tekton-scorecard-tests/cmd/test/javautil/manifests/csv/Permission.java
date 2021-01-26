
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rules",
    "serviceAccountName"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Permission {

    @JsonProperty("rules")
    private List<Rule> rules = new ArrayList<Rule>();
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Permission() {
    }

    /**
     *
     * @param serviceAccountName
     * @param rules
     */
    public Permission(List<Rule> rules, String serviceAccountName) {
        super();
        this.rules = rules;
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("rules")
    public List<Rule> getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public Permission withRules(List<Rule> rules) {
        this.rules = rules;
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

    public Permission withServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Permission.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rules");
        sb.append('=');
        sb.append(((this.rules == null)?"<null>":this.rules));
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
        result = ((result* 31)+((this.rules == null)? 0 :this.rules.hashCode()));
        result = ((result* 31)+((this.serviceAccountName == null)? 0 :this.serviceAccountName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Permission) == false) {
            return false;
        }
        Permission rhs = ((Permission) other);
        return (((this.rules == rhs.rules)||((this.rules!= null)&&this.rules.equals(rhs.rules)))&&((this.serviceAccountName == rhs.serviceAccountName)||((this.serviceAccountName!= null)&&this.serviceAccountName.equals(rhs.serviceAccountName))));
    }

}
