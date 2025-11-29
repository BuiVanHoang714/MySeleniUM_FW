
package reports;

import com.aventstack.extentreports.ExtentTest;
import lombok.Getter;


public class ExtentManager {

    @Getter
    private static ExtentTest extentTest;

    public static void setExtentTest(ExtentTest extentTest) {
        ExtentManager.extentTest = extentTest;
    }


}
