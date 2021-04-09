# Notes on building test images with Java/Quarkus
- The file `<project_root>/pom.xml` has the needed Quarkus dependencies to build a test image.
- You should be able to build an image for `linux/amd64` arch by issuing the following:
```bash
mvn package -Pnative -Dquarkus.native.container-build=true
```
- This will cause a builder container image to download, that image includes:
  `GraalVM Version 20.2.0 (Java Version 11.0.8`, or similar, that will do the native image compiling.
- The Java `sourceDirectory` is set in the `pom.xml` to be the same as the Go files.
- Maven will create target dir with the binary, for native image it will be called something like:
```
tekton-scorecard-image-1.0-SNAPSHOT-runner
```

Define a JAVA_IMAGE to override the default, for example:
```bash
export JAVA_IMAGE=quay.io/operator-framework/tekton-scorecard-java-image
```
##Java test usage notes:

`make image-build-java`

do:

`docker login -u kubeadmin -p $(oc whoami -t) default-route-openshift-image-registry.apps-crc.testing`

before:

`make docker-push`

then:

`make runtests`

or to just try java locally run jar directly with:

`make build-java`
`java -jar target/tekton-scorecard-image-1.0-SNAPSHOT-runner.jar test`

or just

`make tag-update && make image-build-java && make docker-push-java`

(the local run jar option assumes you've tweaked the bundle dir from `/bundle` to `./bundle`)

## Java dev notes:
- with fabric8 CSV class and local generated CSV both used we can only deserialize:
```  
  ./bundle/manifests/memcached-operator.clusterserviceversion.yaml
  Failed to deserialize with any CSV family class: cache.example.com_memcacheds_crd.yaml
  ./bundle/metadata/annotations.yaml
```  
-  https://quarkus.io/guides/command-mode-reference is a good reference for this type of Quarkus Java app.

