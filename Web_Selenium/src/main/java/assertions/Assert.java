package assertions;

import reports.ExtentLogger;

public class Assert {
    private static final String TAB = "&nbsp;&nbsp;&nbsp;&nbsp;";

    private static final String NEW_LINE = "<br>";

    public void assertEquals(final String actual, final String expected, final String description, boolean isHard) {
        if (actual.equals(expected)) {
            ExtentLogger.pass(formatPassEqualMsg(expected, description));
        } else {
            if (!isHard) {
                ExtentLogger.fail(formatFailEqualMsg(actual, expected, description), true);
            } else {
                throw new AssertionError();
            }
        }
    }

    public void assertTrue(boolean condition, final String description, boolean isHard) {
        if (condition) {
            ExtentLogger.pass(formatEqualTrueMsg(description), false);
        } else {
            if (!isHard) {
                ExtentLogger.fail(formatEqualTrueMsg(description), true);
            } else {
                throw new AssertionError();
            }
        }
    }

    public void assertEquals(final int actual, final int expected, final String description, boolean isHard) {
        if (actual == expected) {
            ExtentLogger.pass(formatPassEqualMsg(String.valueOf(expected), description));
        } else {
            if (!isHard) {
                ExtentLogger.fail(formatFailEqualMsg(String.valueOf(actual), String.valueOf(expected), description), true);
            } else {
                throw new AssertionError();
            }
        }
    }

    public void assertEquals(final double actual, final double expected, final String description, boolean isHard) {
        if (actual == expected) {
            ExtentLogger.pass(formatPassEqualMsg(String.valueOf(expected), description));
        } else {
            if (!isHard) {
                ExtentLogger.fail(formatFailEqualMsg(String.valueOf(actual), String.valueOf(expected), description), true);
            } else {
                throw new AssertionError();
            }
        }
    }


    private static String formatPassEqualMsg(String expected, String description) {
        return String.format("%s+ %s %s.", TAB, description, expected);

    }

    private static String formatFailEqualMsg(String actual, String expected, String description) {
        return String.format("%s+ %s%s%s- Expected: %s%s%s- Actual: %s", TAB, description, NEW_LINE, TAB + TAB, expected, NEW_LINE, TAB + TAB, actual);
    }

    private static String formatEqualTrueMsg(String description) {
        return String.format("%s+ %s", TAB, description);

    }


}

