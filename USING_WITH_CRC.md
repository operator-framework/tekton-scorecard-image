### Note on using with Code Ready Containers (CRC): 

The externally reachable URL for the CRC built-in registry, like for the Makefile, is:<br>
`default-route-openshift-image-registry.apps-crc.testing/default/tekton-scorecard-image`<p>
Which corresponds to the internally reachable registry image:<br>
`image-registry.openshift-image-registry.svc:5000/default/tekton-scorecard-image`

Test image names must match in `bundle/tests/scorecard/config.yaml`

For Java tests, might want:
`export JAVA_IMAGE=default-route-openshift-image-registry.apps-crc.testing/default/tekton-scorecard-java-image`