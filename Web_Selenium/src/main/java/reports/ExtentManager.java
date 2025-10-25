
package reports;

import com.aventstack.extentreports.ExtentTest;



public class ExtentManager {

    private static ExtentTest extentTest;

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    public static void setExtentTest(ExtentTest extentTest) {
        ExtentManager.extentTest = extentTest;
    }



}
