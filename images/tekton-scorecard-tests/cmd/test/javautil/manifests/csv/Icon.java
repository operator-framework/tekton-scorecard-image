
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "base64data",
    "mediatype"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Icon {

    @JsonProperty("base64data")
    private String base64data;
    @JsonProperty("mediatype")
    private String mediatype;

    /**
     * No args constructor for use in serialization
     *
     */
    public Icon() {
    }

    /**
     *
     * @param base64data
     * @param mediatype
     */
    public Icon(String base64data, String mediatype) {
        super();
        this.base64data = base64data;
        this.mediatype = mediatype;
    }

    @JsonProperty("base64data")
    public String getBase64data() {
        return base64data;
    }

    @JsonProperty("base64data")
    public void setBase64data(String base64data) {
        this.base64data = base64data;
    }

    public Icon withBase64data(String base64data) {
        this.base64data = base64data;
        return this;
    }

    @JsonProperty("mediatype")
    public String getMediatype() {
        return mediatype;
    }

    @JsonProperty("mediatype")
    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public Icon withMediatype(String mediatype) {
        this.mediatype = mediatype;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Icon.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("base64data");
        sb.append('=');
        sb.append(((this.base64data == null)?"<null>":this.base64data));
        sb.append(',');
        sb.append("mediatype");
        sb.append('=');
        sb.append(((this.mediatype == null)?"<null>":this.mediatype));
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
        result = ((result* 31)+((this.base64data == null)? 0 :this.base64data.hashCode()));
        result = ((result* 31)+((this.mediatype == null)? 0 :this.mediatype.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Icon) == false) {
            return false;
        }
        Icon rhs = ((Icon) other);
        return (((this.base64data == rhs.base64data)||((this.base64data!= null)&&this.base64data.equals(rhs.base64data)))&&((this.mediatype == rhs.mediatype)||((this.mediatype!= null)&&this.mediatype.equals(rhs.mediatype))));
    }

}
