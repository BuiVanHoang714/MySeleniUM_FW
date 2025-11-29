package assertions;

public class AssertManager {
    private static Assert anAssert;

    public static Assert getAssertions() {
        return anAssert;
    }

    public static void setAssertions(Assert anAssert) {
        AssertManager.anAssert = anAssert;
    }
}


