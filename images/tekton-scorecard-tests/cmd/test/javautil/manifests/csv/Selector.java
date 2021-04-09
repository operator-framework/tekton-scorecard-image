
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matchLabels"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Selector {

    @JsonProperty("matchLabels")
    private MatchLabels matchLabels;

    /**
     * No args constructor for use in serialization
     *
     */
    public Selector() {
    }

    /**
     *
     * @param matchLabels
     */
    public Selector(MatchLabels matchLabels) {
        super();
        this.matchLabels = matchLabels;
    }

    @JsonProperty("matchLabels")
    public MatchLabels getMatchLabels() {
        return matchLabels;
    }

    @JsonProperty("matchLabels")
    public void setMatchLabels(MatchLabels matchLabels) {
        this.matchLabels = matchLabels;
    }

    public Selector withMatchLabels(MatchLabels matchLabels) {
        this.matchLabels = matchLabels;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Selector.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("matchLabels");
        sb.append('=');
        sb.append(((this.matchLabels == null)?"<null>":this.matchLabels));
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
        result = ((result* 31)+((this.matchLabels == null)? 0 :this.matchLabels.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Selector) == false) {
            return false;
        }
        Selector rhs = ((Selector) other);
        return ((this.matchLabels == rhs.matchLabels)||((this.matchLabels!= null)&&this.matchLabels.equals(rhs.matchLabels)));
    }

}
