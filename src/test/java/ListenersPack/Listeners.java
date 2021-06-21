package ListenersPack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import resources.TestBase;

import java.io.IOException;

public class Listeners extends TestBase implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReporterObj();;
    ExtentTest test;
    ThreadLocal<ExtentTest> safeTest = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getMethod().getMethodName());
//        safeTest.set(test);  When you run parallel execution, to acheive thread safety and accurate results.
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS,"Test Passed Successfully.");
//        safeTest.get().log(Status.PASS,"Test Passed Successfully.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.fail(iTestResult.getThrowable());
//        safeTest.get().fail(iTestResult.getThrowable());
        WebDriver driver = null;
        String tcName = iTestResult.getMethod().getMethodName();
        try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(getScreenshotPath(tcName, driver),iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}
