package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private static ExtentTest extentTest;
    private static ExtentSparkReporter spark;




    /*
    Extent Text logging step
    static method lets us use this method anywhere

     */
    public static ExtentTest step(){
        return extentTest;
    }

    /*
    In the event of starting a Test this method while get the testcase Name of the test case we are
    running
     */
    @Override
    public void onTestStart(ITestResult result) {
        String testcaseName = result.getMethod().getMethodName();
        extentTest = extent.createTest(testcaseName);
    }

    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        String reportPath = System.getProperty("user.dir") + "/reports/result.html";
        spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.pass("This TestCase Passed");
    }


    /* On test Failure Test Listener will capture screenshot
    and report it thru extent Test
    message back to us that the test has failed
     */
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverUtil.driver();
        String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        extentTest.addScreenCaptureFromBase64String(screenshot, "Failed");
        extentTest.fail("This Test case failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.skip("This Test Case has been Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
