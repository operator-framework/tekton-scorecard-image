
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fieldPath"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class FieldRef {

    @JsonProperty("fieldPath")
    private String fieldPath;

    /**
     * No args constructor for use in serialization
     *
     */
    public FieldRef() {
    }

    /**
     *
     * @param fieldPath
     */
    public FieldRef(String fieldPath) {
        super();
        this.fieldPath = fieldPath;
    }

    @JsonProperty("fieldPath")
    public String getFieldPath() {
        return fieldPath;
    }

    @JsonProperty("fieldPath")
    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    public FieldRef withFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FieldRef.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fieldPath");
        sb.append('=');
        sb.append(((this.fieldPath == null)?"<null>":this.fieldPath));
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
        result = ((result* 31)+((this.fieldPath == null)? 0 :this.fieldPath.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FieldRef) == false) {
            return false;
        }
        FieldRef rhs = ((FieldRef) other);
        return ((this.fieldPath == rhs.fieldPath)||((this.fieldPath!= null)&&this.fieldPath.equals(rhs.fieldPath)));
    }

}
