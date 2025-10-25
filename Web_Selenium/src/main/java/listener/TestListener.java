package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentLogger;
import reports.ExtentReport;
import utilities.FilesUtil;

public class TestListener implements ITestListener{


    @Override
    public void onStart(ITestContext result) {
        FilesUtil.cleanFolder("./ExtentReport");
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext result) {
        ExtentReport.flushReports();
        ExtentLogger.resetStep();
    }

    @Override
    public void onTestStart(ITestResult result) {
       ExtentReport.createTest(result.getMethod().getMethodName().replaceAll("_", " "));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //doTestPass(result, false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
      doTestFail(result, true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        doTestSkip(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public static void doTestFail(ITestResult result, boolean isScreenShotNeeded){
        String exceptionMessage =  result.getThrowable().toString();
        String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
                + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
                + "</details> \n";
        String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>";
        ExtentLogger.fail(logText + "<br>" + message, isScreenShotNeeded);
    }

    public static void doTestPass(ITestResult result, boolean isScreenShotNeeded){
        String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>";
        ExtentLogger.pass(logText, isScreenShotNeeded);
    }

    public static void doTestSkip(ITestResult result){
        String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>";
        ExtentLogger.skip(logText);
    }

}

