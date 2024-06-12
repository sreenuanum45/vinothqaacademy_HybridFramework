package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyExtentReport {
    public  static ExtentReports generateExtentReport() throws IOException {
        ExtentReports extentReport=new ExtentReports();
        File extentReportFile=new File(System.getProperty("user.dir")+"/test-output/ExtendReport/extent.html");
     ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
     sparkReporter.config().setTheme(Theme.STANDARD);
     sparkReporter.config().setDocumentTitle(" Automation Report");
     sparkReporter.config().setReportName("My Report");
     sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
     sparkReporter.config().setEncoding("utf-8");
     extentReport.attachReporter(sparkReporter);
        Properties config=new Properties();
        File configFile=new File(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
        FileInputStream fis=new FileInputStream(configFile);
        config.load(fis);
     extentReport.setSystemInfo("Applcation url",config.getProperty("url"));
     extentReport.setSystemInfo("Browsername",config.getProperty("browserName"));
     extentReport.setSystemInfo("Username",config.getProperty("validEmail"));
     extentReport.setSystemInfo("OS",System.getProperty("os.name"));
     extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
     extentReport.setSystemInfo("os Version",System.getProperty("os.version"));
     return extentReport ;
     
    }
}
