package base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import projectutility.WebSiteUtility;
import utilities.Utilites_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public RemoteWebDriver driver;
    public Properties p;
    public Properties dataprop;
    public DesiredCapabilities capabilities;
    public FluentWait<RemoteWebDriver> wait;
    public SoftAssert sa;
    public WebSiteUtility su;
@BeforeSuite
public void setUp() {

}
    public BaseClass() {
        File f = new File(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
        File f1 = new File(System.getProperty("user.dir") + "/src/main/java/testdata/testdata.properties");
        try {
            FileInputStream fis1 = new FileInputStream(f1);
            dataprop = new Properties();
            dataprop.load(fis1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            p = new Properties();
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RemoteWebDriver initializeBrowserAndOpenApplication(String browserChoice) {

        if (browserChoice.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        } else if (browserChoice.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browserChoice.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser choice. Please choose 'chrome', 'firefox', or 'edge'.");
            return null;
        }
        sa=new SoftAssert();
        su=new WebSiteUtility();
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(Utilites_1.withTimeout));
        wait.pollingEvery(Duration.ofSeconds(Utilites_1.polling_Time));
        wait.ignoring(Exception.class);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilites_1.wait_Time));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilites_1.page_Loading_Time));
        driver.get(p.getProperty("url"));

        return driver;
    }
    public void makedelay(WebElement e){
        boolean b=true;
        while(b){
            try {
                wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed();

                b = false;
            } catch (Exception e1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }

    }
}
