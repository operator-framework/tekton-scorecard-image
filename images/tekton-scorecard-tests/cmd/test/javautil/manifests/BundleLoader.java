package javautil.manifests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import javautil.manifests.csv.ClusterServiceVersion;
import org.jboss.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BundleLoader {
    String dir;
    boolean foundCSV;
    private static final Logger LOG = Logger.getLogger(BundleLoader.class);

    public BundleLoader(String dir) {
        this.dir = dir;
    }

    public Bundle loadBundle() throws IOException, NotBundleException {
        foundCSV = Files.walk(Paths.get(dir))
                .filter(Files::isRegularFile)
                .anyMatch(p -> {
                    try {
                        return checkCSV(p);
                    } catch (IOException ioException) {
                        //TODO pass deserialization problems up the call chain
                        LOG.trace(ioException.getMessage());
                    }
                    return false;
                });
        if (foundCSV) {
            List<Object> objs = Files.walk(Paths.get(dir))
                    .filter(Files::isRegularFile)
                    .map(p -> getBundleObject(p))
                    .collect(Collectors.toList());
            return assembleBundle(objs);
        } else {
            throw new NotBundleException();
        }
    }

    private Bundle assembleBundle(List<Object> objs) {
        Bundle.BundleBuilder buildBundle = new Bundle.BundleBuilder();
        for (Object obj : objs) {
            if (obj instanceof ClusterServiceVersion) {
                ClusterServiceVersion csv = (ClusterServiceVersion) obj;
                buildBundle.CSV(csv);
                buildBundle.name(csv.getMetadata().getName());
            } else if (obj instanceof CustomResourceDefinition)
                buildBundle.addV1Beta1CRD((CustomResourceDefinition) obj);
            else if (obj instanceof io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition)
                buildBundle.addV1CRD((io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition) obj);
            else if (obj instanceof GenericCustomResource)
                buildBundle.addObject((GenericCustomResource) obj);
        }
        return buildBundle.build();
    }

    private Object getBundleObject(Path path) {
        File maybeYaml = Paths.get(path.toString()).toFile();
        GenericCustomResource bundleObject = null;
        try {
            bundleObject = new ObjectMapper(new YAMLFactory()).readValue(maybeYaml,
                    GenericCustomResource.class);
            LOG.trace("deserialized: " + maybeYaml.getName() +
                    ", kind is: " + bundleObject.getKind() +
                    ", version is: " + bundleObject.getApiVersion());
            if (bundleObject.getKind() == null) {
                return bundleObject;
            }
            if (bundleObject.getKind().equals("CustomResourceDefinition") &&
                    bundleObject.getApiVersion().equals("apiextensions.k8s.io/v1beta1")) {
                return new ObjectMapper(new YAMLFactory()).readValue(maybeYaml,
                        CustomResourceDefinition.class);
            }
            if (bundleObject.getKind().equals("CustomResourceDefinition") &&
                    bundleObject.getApiVersion().equals("apiextensions.k8s.io/v1")) {
                return new ObjectMapper(new YAMLFactory()).readValue(maybeYaml,
                        io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition.class);
            }
            if (bundleObject.getKind().equals("ClusterServiceVersion")) {
                return new ObjectMapper(new YAMLFactory()).readValue(maybeYaml,
                        javautil.manifests.csv.ClusterServiceVersion.class);
            }
        } catch (JsonProcessingException e2) {
            System.out.println("Failed to deserialize with our CSV class: " + maybeYaml.getName());
        } catch (IOException ioException) {
            System.out.println("Failed to open: " + maybeYaml.getName());
            ioException.printStackTrace();
        }
        return bundleObject;
    }

    private boolean checkCSV(Path path) throws IOException {
        File maybeYaml = Paths.get(path.toString()).toFile();
        //TODO this usage of local CSV classes can go away once
        // https://github.com/fabric8io/kubernetes-client/issues/2784 resolved
        javautil.manifests.csv.ClusterServiceVersion maybeLocalCSV = null;
        boolean csvFamilyFound = false;
        try {
            maybeLocalCSV = new ObjectMapper(new YAMLFactory()).readValue(maybeYaml,
                    javautil.manifests.csv.ClusterServiceVersion.class);
            csvFamilyFound = true;
        } catch (JsonProcessingException e2) {
            throw e2;
        } catch (IOException ioException) {
            throw ioException;
        }
        if (csvFamilyFound) {
            if (maybeLocalCSV.getKind().equals(javautil.manifests.csv.ClusterServiceVersion.class.getSimpleName())) {
                foundCSV = true;
                return true;
            }
        }
        return false;
    }
}
