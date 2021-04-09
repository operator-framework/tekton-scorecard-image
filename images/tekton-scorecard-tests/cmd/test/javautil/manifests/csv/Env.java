
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "valueFrom",
    "value"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Env {

    @JsonProperty("name")
    private String name;
    @JsonProperty("valueFrom")
    private ValueFrom valueFrom;
    @JsonProperty("value")
    private String value;

    /**
     * No args constructor for use in serialization
     *
     */
    public Env() {
    }

    /**
     *
     * @param name
     * @param value
     * @param valueFrom
     */
    public Env(String name, ValueFrom valueFrom, String value) {
        super();
        this.name = name;
        this.valueFrom = valueFrom;
        this.value = value;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Env withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("valueFrom")
    public ValueFrom getValueFrom() {
        return valueFrom;
    }

    @JsonProperty("valueFrom")
    public void setValueFrom(ValueFrom valueFrom) {
        this.valueFrom = valueFrom;
    }

    public Env withValueFrom(ValueFrom valueFrom) {
        this.valueFrom = valueFrom;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Env withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Env.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("valueFrom");
        sb.append('=');
        sb.append(((this.valueFrom == null)?"<null>":this.valueFrom));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        result = ((result* 31)+((this.valueFrom == null)? 0 :this.valueFrom.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Env) == false) {
            return false;
        }
        Env rhs = ((Env) other);
        return ((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))))&&((this.valueFrom == rhs.valueFrom)||((this.valueFrom!= null)&&this.valueFrom.equals(rhs.valueFrom))));
    }

}
