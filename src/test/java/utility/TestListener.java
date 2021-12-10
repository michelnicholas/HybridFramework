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


    public static ExtentTest step(String message){
        return extentTest;
    }

    public static ExtentTest step(){
        return extentTest;
    }


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
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
        ITestListener.super.onTestSkipped(result);
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
        ITestListener.super.onFinish(context);
    }
}
