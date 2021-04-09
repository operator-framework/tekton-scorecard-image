
package javautil.manifests.csv;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiservicedefinitions",
    "customresourcedefinitions",
    "description",
    "displayName",
    "icon",
    "install",
    "installModes",
    "keywords",
    "maintainers",
    "maturity",
    "provider",
    "version"
})
@io.quarkus.runtime.annotations.RegisterForReflection
public class Spec {

    @JsonProperty("apiservicedefinitions")
    private Apiservicedefinitions apiservicedefinitions;
    @JsonProperty("customresourcedefinitions")
    private Customresourcedefinitions customresourcedefinitions;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("icon")
    private List<Icon> icon = new ArrayList<Icon>();
    @JsonProperty("install")
    private Install install;
    @JsonProperty("installModes")
    private List<InstallMode> installModes = new ArrayList<InstallMode>();
    @JsonProperty("keywords")
    private List<String> keywords = new ArrayList<String>();
    @JsonProperty("maintainers")
    private List<Maintainer> maintainers = new ArrayList<Maintainer>();
    @JsonProperty("maturity")
    private String maturity;
    @JsonProperty("provider")
    private Provider provider;
    @JsonProperty("version")
    private String version;

    /**
     * No args constructor for use in serialization
     *
     */
    public Spec() {
    }

    /**
     *
     * @param maintainers
     * @param customresourcedefinitions
     * @param installModes
     * @param keywords
     * @param apiservicedefinitions
     * @param install
     * @param maturity
     * @param provider
     * @param displayName
     * @param icon
     * @param description
     * @param version
     */
    public Spec(Apiservicedefinitions apiservicedefinitions, Customresourcedefinitions customresourcedefinitions, String description, String displayName, List<Icon> icon, Install install, List<InstallMode> installModes, List<String> keywords, List<Maintainer> maintainers, String maturity, Provider provider, String version) {
        super();
        this.apiservicedefinitions = apiservicedefinitions;
        this.customresourcedefinitions = customresourcedefinitions;
        this.description = description;
        this.displayName = displayName;
        this.icon = icon;
        this.install = install;
        this.installModes = installModes;
        this.keywords = keywords;
        this.maintainers = maintainers;
        this.maturity = maturity;
        this.provider = provider;
        this.version = version;
    }

    @JsonProperty("apiservicedefinitions")
    public Apiservicedefinitions getApiservicedefinitions() {
        return apiservicedefinitions;
    }

    @JsonProperty("apiservicedefinitions")
    public void setApiservicedefinitions(Apiservicedefinitions apiservicedefinitions) {
        this.apiservicedefinitions = apiservicedefinitions;
    }

    public Spec withApiservicedefinitions(Apiservicedefinitions apiservicedefinitions) {
        this.apiservicedefinitions = apiservicedefinitions;
        return this;
    }

    @JsonProperty("customresourcedefinitions")
    public Customresourcedefinitions getCustomresourcedefinitions() {
        return customresourcedefinitions;
    }

    @JsonProperty("customresourcedefinitions")
    public void setCustomresourcedefinitions(Customresourcedefinitions customresourcedefinitions) {
        this.customresourcedefinitions = customresourcedefinitions;
    }

    public Spec withCustomresourcedefinitions(Customresourcedefinitions customresourcedefinitions) {
        this.customresourcedefinitions = customresourcedefinitions;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Spec withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Spec withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    @JsonProperty("icon")
    public List<Icon> getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(List<Icon> icon) {
        this.icon = icon;
    }

    public Spec withIcon(List<Icon> icon) {
        this.icon = icon;
        return this;
    }

    @JsonProperty("install")
    public Install getInstall() {
        return install;
    }

    @JsonProperty("install")
    public void setInstall(Install install) {
        this.install = install;
    }

    public Spec withInstall(Install install) {
        this.install = install;
        return this;
    }

    @JsonProperty("installModes")
    public List<InstallMode> getInstallModes() {
        return installModes;
    }

    @JsonProperty("installModes")
    public void setInstallModes(List<InstallMode> installModes) {
        this.installModes = installModes;
    }

    public Spec withInstallModes(List<InstallMode> installModes) {
        this.installModes = installModes;
        return this;
    }

    @JsonProperty("keywords")
    public List<String> getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Spec withKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    @JsonProperty("maintainers")
    public List<Maintainer> getMaintainers() {
        return maintainers;
    }

    @JsonProperty("maintainers")
    public void setMaintainers(List<Maintainer> maintainers) {
        this.maintainers = maintainers;
    }

    public Spec withMaintainers(List<Maintainer> maintainers) {
        this.maintainers = maintainers;
        return this;
    }

    @JsonProperty("maturity")
    public String getMaturity() {
        return maturity;
    }

    @JsonProperty("maturity")
    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public Spec withMaturity(String maturity) {
        this.maturity = maturity;
        return this;
    }

    @JsonProperty("provider")
    public Provider getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Spec withProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Spec withVersion(String version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spec.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apiservicedefinitions");
        sb.append('=');
        sb.append(((this.apiservicedefinitions == null)?"<null>":this.apiservicedefinitions));
        sb.append(',');
        sb.append("customresourcedefinitions");
        sb.append('=');
        sb.append(((this.customresourcedefinitions == null)?"<null>":this.customresourcedefinitions));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("icon");
        sb.append('=');
        sb.append(((this.icon == null)?"<null>":this.icon));
        sb.append(',');
        sb.append("install");
        sb.append('=');
        sb.append(((this.install == null)?"<null>":this.install));
        sb.append(',');
        sb.append("installModes");
        sb.append('=');
        sb.append(((this.installModes == null)?"<null>":this.installModes));
        sb.append(',');
        sb.append("keywords");
        sb.append('=');
        sb.append(((this.keywords == null)?"<null>":this.keywords));
        sb.append(',');
        sb.append("maintainers");
        sb.append('=');
        sb.append(((this.maintainers == null)?"<null>":this.maintainers));
        sb.append(',');
        sb.append("maturity");
        sb.append('=');
        sb.append(((this.maturity == null)?"<null>":this.maturity));
        sb.append(',');
        sb.append("provider");
        sb.append('=');
        sb.append(((this.provider == null)?"<null>":this.provider));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
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
        result = ((result* 31)+((this.maintainers == null)? 0 :this.maintainers.hashCode()));
        result = ((result* 31)+((this.customresourcedefinitions == null)? 0 :this.customresourcedefinitions.hashCode()));
        result = ((result* 31)+((this.installModes == null)? 0 :this.installModes.hashCode()));
        result = ((result* 31)+((this.keywords == null)? 0 :this.keywords.hashCode()));
        result = ((result* 31)+((this.apiservicedefinitions == null)? 0 :this.apiservicedefinitions.hashCode()));
        result = ((result* 31)+((this.maturity == null)? 0 :this.maturity.hashCode()));
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        result = ((result* 31)+((this.icon == null)? 0 :this.icon.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.install == null)? 0 :this.install.hashCode()));
        result = ((result* 31)+((this.provider == null)? 0 :this.provider.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec) == false) {
            return false;
        }
        Spec rhs = ((Spec) other);
        return (((((((((((((this.maintainers == rhs.maintainers)||((this.maintainers!= null)&&this.maintainers.equals(rhs.maintainers)))&&((this.customresourcedefinitions == rhs.customresourcedefinitions)||((this.customresourcedefinitions!= null)&&this.customresourcedefinitions.equals(rhs.customresourcedefinitions))))&&((this.installModes == rhs.installModes)||((this.installModes!= null)&&this.installModes.equals(rhs.installModes))))&&((this.keywords == rhs.keywords)||((this.keywords!= null)&&this.keywords.equals(rhs.keywords))))&&((this.apiservicedefinitions == rhs.apiservicedefinitions)||((this.apiservicedefinitions!= null)&&this.apiservicedefinitions.equals(rhs.apiservicedefinitions))))&&((this.maturity == rhs.maturity)||((this.maturity!= null)&&this.maturity.equals(rhs.maturity))))&&((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName))))&&((this.icon == rhs.icon)||((this.icon!= null)&&this.icon.equals(rhs.icon))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.install == rhs.install)||((this.install!= null)&&this.install.equals(rhs.install))))&&((this.provider == rhs.provider)||((this.provider!= null)&&this.provider.equals(rhs.provider))));
    }

}
