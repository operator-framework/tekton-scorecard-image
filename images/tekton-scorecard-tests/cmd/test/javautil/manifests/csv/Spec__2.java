
package javautil.manifests.csv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "replicas",
    "selector",
    "strategy",
    "template"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Spec__2 {

    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("selector")
    private Selector selector;
    @JsonProperty("strategy")
    private Strategy strategy;
    @JsonProperty("template")
    private Template template;

    /**
     * No args constructor for use in serialization
     *
     */
    public Spec__2() {
    }

    /**
     *
     * @param template
     * @param replicas
     * @param selector
     * @param strategy
     */
    public Spec__2(Integer replicas, Selector selector, Strategy strategy, Template template) {
        super();
        this.replicas = replicas;
        this.selector = selector;
        this.strategy = strategy;
        this.template = template;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    public Spec__2 withReplicas(Integer replicas) {
        this.replicas = replicas;
        return this;
    }

    @JsonProperty("selector")
    public Selector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public Spec__2 withSelector(Selector selector) {
        this.selector = selector;
        return this;
    }

    @JsonProperty("strategy")
    public Strategy getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Spec__2 withStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }

    @JsonProperty("template")
    public Template getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(Template template) {
        this.template = template;
    }

    public Spec__2 withTemplate(Template template) {
        this.template = template;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spec__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("replicas");
        sb.append('=');
        sb.append(((this.replicas == null)?"<null>":this.replicas));
        sb.append(',');
        sb.append("selector");
        sb.append('=');
        sb.append(((this.selector == null)?"<null>":this.selector));
        sb.append(',');
        sb.append("strategy");
        sb.append('=');
        sb.append(((this.strategy == null)?"<null>":this.strategy));
        sb.append(',');
        sb.append("template");
        sb.append('=');
        sb.append(((this.template == null)?"<null>":this.template));
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
        result = ((result* 31)+((this.template == null)? 0 :this.template.hashCode()));
        result = ((result* 31)+((this.selector == null)? 0 :this.selector.hashCode()));
        result = ((result* 31)+((this.strategy == null)? 0 :this.strategy.hashCode()));
        result = ((result* 31)+((this.replicas == null)? 0 :this.replicas.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec__2) == false) {
            return false;
        }
        Spec__2 rhs = ((Spec__2) other);
        return (((((this.template == rhs.template)||((this.template!= null)&&this.template.equals(rhs.template)))&&((this.selector == rhs.selector)||((this.selector!= null)&&this.selector.equals(rhs.selector))))&&((this.strategy == rhs.strategy)||((this.strategy!= null)&&this.strategy.equals(rhs.strategy))))&&((this.replicas == rhs.replicas)||((this.replicas!= null)&&this.replicas.equals(rhs.replicas))));
    }

}
