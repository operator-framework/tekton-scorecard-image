
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "owned"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Customresourcedefinitions {

    @JsonProperty("owned")
    private List<Owned> owned = new ArrayList<Owned>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Customresourcedefinitions() {
    }

    /**
     *
     * @param owned
     */
    public Customresourcedefinitions(List<Owned> owned) {
        super();
        this.owned = owned;
    }

    @JsonProperty("owned")
    public List<Owned> getOwned() {
        return owned;
    }

    @JsonProperty("owned")
    public void setOwned(List<Owned> owned) {
        this.owned = owned;
    }

    public Customresourcedefinitions withOwned(List<Owned> owned) {
        this.owned = owned;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Customresourcedefinitions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("owned");
        sb.append('=');
        sb.append(((this.owned == null)?"<null>":this.owned));
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
        result = ((result* 31)+((this.owned == null)? 0 :this.owned.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customresourcedefinitions) == false) {
            return false;
        }
        Customresourcedefinitions rhs = ((Customresourcedefinitions) other);
        return ((this.owned == rhs.owned)||((this.owned!= null)&&this.owned.equals(rhs.owned)));
    }

}
