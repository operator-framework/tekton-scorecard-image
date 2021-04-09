
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fieldRef"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class ValueFrom {

    @JsonProperty("fieldRef")
    private FieldRef fieldRef;

    /**
     * No args constructor for use in serialization
     *
     */
    public ValueFrom() {
    }

    /**
     *
     * @param fieldRef
     */
    public ValueFrom(FieldRef fieldRef) {
        super();
        this.fieldRef = fieldRef;
    }

    @JsonProperty("fieldRef")
    public FieldRef getFieldRef() {
        return fieldRef;
    }

    @JsonProperty("fieldRef")
    public void setFieldRef(FieldRef fieldRef) {
        this.fieldRef = fieldRef;
    }

    public ValueFrom withFieldRef(FieldRef fieldRef) {
        this.fieldRef = fieldRef;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ValueFrom.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fieldRef");
        sb.append('=');
        sb.append(((this.fieldRef == null)?"<null>":this.fieldRef));
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
        result = ((result* 31)+((this.fieldRef == null)? 0 :this.fieldRef.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ValueFrom) == false) {
            return false;
        }
        ValueFrom rhs = ((ValueFrom) other);
        return ((this.fieldRef == rhs.fieldRef)||((this.fieldRef!= null)&&this.fieldRef.equals(rhs.fieldRef)));
    }

}
