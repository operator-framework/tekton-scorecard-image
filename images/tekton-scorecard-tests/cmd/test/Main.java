import com.google.common.base.Strings;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import javautil.manifests.Bundle;
import javautil.manifests.Manifests;
import tests.OperatorRunningTest;
import tests.Tests;

@QuarkusMain
public class Main implements QuarkusApplication {
    private static final String PodBundleRoot = "/bundle";

    @Override
    public int run(String... args) throws Exception {
        if (args.length == 0) {
            throw new RuntimeException("Must pass args, including, at least, test name.");
        }
        var entrypoint = args[0];
        if (Strings.isNullOrEmpty(entrypoint)) {
            throw new RuntimeException("Test name argument required");
        }
        Bundle bundle = Manifests.GetBundleFromDir(PodBundleRoot);

        switch (entrypoint){
            case Tests.CustomTest1Name:
                System.out.println(Tests.customTest1(bundle));
                break;
            case Tests.CustomTest2Name:
                System.out.println(Tests.customTest2(bundle));
                break;
            case OperatorRunningTest
                    .OperatorRunningTestName:
                System.out.println(OperatorRunningTest.operatorRunningTest(bundle));
                break;
            default:
                System.out.printf("test %s did not match any known tests", entrypoint);
        }
        return 0;
    }
}