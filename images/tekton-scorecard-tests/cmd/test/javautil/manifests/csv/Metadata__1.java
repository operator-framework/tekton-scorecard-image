
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Metadata__1 {

    @JsonProperty("labels")
    private Labels labels;

    /**
     * No args constructor for use in serialization
     *
     */
    public Metadata__1() {
    }

    /**
     *
     * @param labels
     */
    public Metadata__1(Labels labels) {
        super();
        this.labels = labels;
    }

    @JsonProperty("labels")
    public Labels getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public Metadata__1 withLabels(Labels labels) {
        this.labels = labels;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Metadata__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
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
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metadata__1) == false) {
            return false;
        }
        Metadata__1 rhs = ((Metadata__1) other);
        return ((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels)));
    }

}
