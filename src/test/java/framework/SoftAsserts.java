package framework;

import org.testng.asserts.SoftAssert;

public class SoftAsserts {

    private static ThreadLocal<SoftAssert> softAssert = ThreadLocal.withInitial(SoftAssert::new);

    private SoftAsserts() {
    }

    public static SoftAssert getInstance() {
        if (softAssert.get() == null) {
            softAssert.set(new SoftAssert());
        }
        return softAssert.get();
    }

    public static void refreshSoftAssert() {
        softAssert.set(null);
    }
}