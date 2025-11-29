package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;
import java.io.File; // added

public final class ExtentReport {

    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {

            // Ensure ./ExtentReport exists in current working directory
            File reportDir = new File("./ExtentReport");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            extent = new ExtentReports();
            ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentReport/report.html");
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setReportName("Hoang's Report");
            reporter.config().setCSS(".r-img { width: 30%; }");
            extent.attachReporter(reporter);
            extent.setSystemInfo("Win 10", "Chrome browser");

        }
    }

    public static void flushReports() {
        extent.flush();
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }


}
