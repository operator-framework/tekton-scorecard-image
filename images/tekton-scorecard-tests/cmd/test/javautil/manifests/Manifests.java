package javautil.manifests;

import java.io.IOException;

public class Manifests {

    public Manifests() {
    }

    /**
     * serializes component files (CSVs, CRDs, other native kube manifests)
     *
     * @param dir a raw directory containing an Operator Bundle
     * @return serialized bundle
     */
    public static Bundle GetBundleFromDir(String dir) throws IOException, NotBundleException {
        BundleLoader loader = new BundleLoader(dir);
        return loader.loadBundle();
    }
}
