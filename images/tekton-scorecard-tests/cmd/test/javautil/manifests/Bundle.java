package javautil.manifests;

import java.util.ArrayList;
import java.util.List;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
//import io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersion;
import javautil.manifests.csv.ClusterServiceVersion;

import static io.fabric8.zjsonpatch.internal.guava.Preconditions.checkArgument;

public class Bundle {
    private final String name;
    private final List<GenericCustomResource> objects;
    private final String bundlePackage;
    private List<String> channels;
    private final String defaultChannel;
    private final String bundleImage;
    private final ClusterServiceVersion CSV;
    private List<CustomResourceDefinition> v1beta1CRDs;
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition> v1CRDs;
    private List<Dependency> dependencies;

    private Bundle(BundleBuilder builder) {
        this.name = builder.name;
        this.objects = builder.objects;
        this.bundlePackage = builder.bundlePackage;
        this.channels = builder.channels;
        this.defaultChannel = builder.defaultChannel;
        this.bundleImage = builder.bundleImage;
        this.CSV = builder.CSV;
        this.v1beta1CRDs = builder.v1beta1CRDs;
        this.v1CRDs = builder.v1CRDs;
        this.dependencies = builder.dependencies;
    }

    public String getName() {
        return name;
    }
    public List<GenericCustomResource> getObjects() {
        return objects;
    }
    public String getBundlePackage() {
        return bundlePackage;
    }
    public List<String> getChannels() {
        return channels;
    }
    public String getDefaultChannel() {
        return defaultChannel;
    }
    public String getBundleImage() {
        return bundleImage;
    }
    public ClusterServiceVersion getCSV() {
        return CSV;
    }
    public List<CustomResourceDefinition> getV1beta1CRDs() {
        return v1beta1CRDs;
    }
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition> getV1CRDs() {
        return v1CRDs;
    }
    public List<Dependency> getDependencies() {
        return dependencies;
    }

    @Override
    public String toString() {
        return "Bundle: " + this.name + ", " + this.objects + ", " + this.bundlePackage + ", " +
                this.channels + ", " + this.defaultChannel + ", " + this.bundleImage + ", " + this.CSV + ", " +
                this.v1beta1CRDs + ", " + this.v1CRDs + ", " + ", " + this.dependencies;
    }

    public static class BundleBuilder {
        private String name;
        private List<GenericCustomResource> objects;
        private String bundlePackage;
        private List<String> channels;
        private String defaultChannel;
        private String bundleImage;
        private ClusterServiceVersion CSV;
        private List<CustomResourceDefinition> v1beta1CRDs;
        private List<io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition> v1CRDs;
        private List<Dependency> dependencies;

        public BundleBuilder() {
        }

        public BundleBuilder CSV(ClusterServiceVersion CSV) {
            checkArgument(CSV != null, "CSV must be provided for a Bundle");
            this.CSV = CSV;
            return this;
        }
        public BundleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BundleBuilder objects(List<GenericCustomResource> objects) {
            this.objects = objects;
            return this;
        }

        public void addObject(GenericCustomResource obj) {
            if (objects == null) objects = new ArrayList<GenericCustomResource>();
            objects.add(obj);
        }

        public BundleBuilder bundlePackage(String bundlePackage) {
            this.bundlePackage = bundlePackage;
            return this;
        }

        public BundleBuilder channels(List<String> channels) {
            this.channels = channels;
            return this;
        }

        public void addChannel(String channel) {
            if (channels == null) channels = new ArrayList<String>();
            channels.add(channel);
        }

        public BundleBuilder defaultChannel(String defaultChannel) {
            this.defaultChannel = defaultChannel;
            return this;
        }

        public BundleBuilder bundleImage(String bundleImage) {
            this.bundleImage = bundleImage;
            return this;
        }

        public BundleBuilder v1beta1CRDs(List<CustomResourceDefinition> v1beta1CRDs) {
            this.v1beta1CRDs = v1beta1CRDs;
            return this;
        }

        public void addV1Beta1CRD(CustomResourceDefinition v1Beta1CRD) {
            if (v1beta1CRDs == null) v1beta1CRDs = new ArrayList<CustomResourceDefinition>();
            v1beta1CRDs.add(v1Beta1CRD);
        }

        public BundleBuilder v1CRDs(
                List<io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition> v1CRDs) {
            this.v1CRDs = v1CRDs;
            return this;
        }

        public void addV1CRD(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition v1CRD) {
            if (v1CRDs == null) {
                v1CRDs = new ArrayList<io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition>();
            }
            v1CRDs.add(v1CRD);
        }

        public BundleBuilder dependencies(List<Dependency> dependencies) {
            this.dependencies = dependencies;
            return this;
        }

        public void addDependency(Dependency dependency) {
            if (dependencies == null) dependencies = new ArrayList<Dependency>();
            dependencies.add(dependency);
        }

        public Bundle build() {
            Bundle bundle = new Bundle(this);
            return bundle;
        }
    }
}