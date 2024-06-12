package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.MyExtentReport;
import utilities.Utilites_1;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyListeners  extends base.BaseClass implements ITestListener   {
    public ExtentReports extentReport;
    public ExtentTest extentTest;
    private  static  ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public  RemoteWebDriver driver;


    @Override
    public void onTestStart(ITestResult result) {
        extentTest=extentReport.createTest(result.getName());
        extentTest.log(Status.INFO,result.getName()+" is Started Executing");

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,result.getName()+" is Executed Successfully");
        System.out.println(result.getName()+" is Executed  got Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        RemoteWebDriver driver;
        String destinationScreenshot;
        try {
            driver = (RemoteWebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try {
            destinationScreenshot=Utilites_1.caputureScreenshot(driver, result.getName());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try {
            extentTest.addScreenCaptureFromPath(destinationScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL, result.getName()+"got Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP, result.getName()+" is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {


    }

    @Override
    public void onStart(ITestContext context) {
        try {
            extentReport=MyExtentReport.generateExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void logInfo(String message) {
        test.get().log(Status.INFO, message);

    }
    @Override
    public void onFinish(ITestContext context) {
    extentReport.flush();
        try {
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\test-output\\ExtendReport\\extent.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void logWarning(String message) {
        test.get().log(Status.WARNING, message);
    }
    public static void Pass(String message) {
        test.get().log(Status.PASS, message);
    }
    public static void Fail(String message) {
        test.get().log(Status.FAIL, message);

    }
    public static void SKIP(String message) {
        test.get().log(Status.SKIP, message);
    }
    public static void logScreenshot(String description, String base64Screenshot) {
        try {
            test.get().log(Status.INFO, description, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            System.out.println("Exception while adding screenshot to report: " + e.getMessage());
        }
    }

}
