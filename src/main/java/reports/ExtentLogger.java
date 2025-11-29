/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 * Tutor: Amuthan Sakthivel (https://www.testingminibytes.com/)
 */

/***************************************************/

package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.DriverManager;
import utilities.ScreenshotUtil;

import java.io.IOException;

public final class ExtentLogger {
    private static final String TAB = "&nbsp;&nbsp;&nbsp;&nbsp;";

    private static int index = 1;

    public static String step() {
        int currentIdx = index;
        index ++;
        return currentIdx + ". ";
    }

    public static void resetStep() {
        index = 1;
    }

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(step() + message);
    }

    public static void details(String message) {
        ExtentManager.getExtentTest().info(TAB + "+ " + message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        String filePath = ScreenshotUtil.getScreenshot(DriverManager.getDriver());

        if (isScreenshotNeeded) {
            try {
                ExtentManager.getExtentTest().pass(message,
                        MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        String filePath = ScreenshotUtil.getScreenshot(DriverManager.getDriver());
        if (isScreenshotNeeded) {
            try {
                ExtentManager.getExtentTest().fail(message,
                        MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            fail(message);
        }
    }


}
