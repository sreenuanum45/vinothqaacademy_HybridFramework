package Testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import base.BaseClass;
import com.github.javafaker.Faker;
import listeners.MyListeners;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegistrationFormPage;
import pages.TransactionDetailsPage;
import projectutility.ScreenShotUtility;
import projectutility.WebSiteUtility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

@Listeners(MyListeners.class)
@Slf4j
public class Verify_RegisterForm extends BaseClass {
  public   RemoteWebDriver driver;
  public HomePage homePage;
  public FluentWait<RemoteWebDriver>wait;
  public RegistrationFormPage registrationFormPage;
   public Date date;
   public TransactionDetailsPage transactionDetailsPage;
    public SoftAssert sa;
    public String expectedTitle;

  public   ATUTestRecorder recorder;
   public SimpleDateFormat sf;

  public WebSiteUtility su;
  public Faker faker;
  public ScreenShotUtility screenShotUtility;

  public Verify_RegisterForm(){
      super();
  }
 @BeforeClass
 public void initializeBrowserAndOpenApplication() throws IOException, ATUTestRecorderException {
     /*sf=new SimpleDateFormat("dd-MMM-yyy-hh-mm-ss");
     date=new Date();
     String vp="target\\"+sf.format(date);
     recorder=new ATUTestRecorder(vp,true);
     recorder.start();*/
     sa=new SoftAssert();
su=new WebSiteUtility();

 }
    @BeforeMethod
    public void setup() throws ElementClickInterceptedException {
        driver= initializeBrowserAndOpenApplication(p.getProperty("browserName"));
        faker=new Faker();
    }
    @Test(priority = 1,dataProvider= "RegisterFormTestData")
  public void Verify_RegisterFormWithDSameData(String firstName,String lastName,String streetAddress,String apartmentAddress,String city,String statename,String postalcodeNumber,String countryName,String email_id,String mobileNumber,String enter_your_query) throws Throwable {
      homePage = new HomePage(driver, new FluentWait<RemoteWebDriver>(driver));
      homePage.moveToDemoSite();
      homePage.moveToPracticeAutomation();
      registrationFormPage=homePage.moveToRegistrationForm();registrationFormPage.Registrationform(firstName,lastName,streetAddress,apartmentAddress,city,statename,postalcodeNumber,countryName,email_id,mobileNumber,enter_your_query);
    }
    @Test(priority = 2)
    public void Verify_RegisterFormWithoutAllFields() throws Throwable {
      homePage = new HomePage(driver, new FluentWait<RemoteWebDriver>(driver));
        homePage.moveToDemoSite();
        homePage.moveToPracticeAutomation();
        registrationFormPage=homePage.moveToRegistrationForm();
        registrationFormPage.Registrationform("","","","","","","","","","","");
        Thread.sleep(3000);
        /*registrationFormPage.validateFirstNameErrorMsg();
        registrationFormPage.validateLastNameErrorMsg();
        registrationFormPage.validateEmailErrorMsg();*/
  }
    @Test(priority = 3,invocationCount = 1,enabled = true,threadPoolSize = 2,groups = "sanity")
    public void Verify_RegisterFormWithAllFields() throws Throwable {
        try {
            String actualTitle = driver.getTitle();
            expectedTitle  = new Properties().getProperty("expectedTitle");

            homePage = new HomePage(driver, new FluentWait<RemoteWebDriver>(driver));
            homePage.moveToDemoSite();
            homePage.moveToPracticeAutomation();
            registrationFormPage = homePage.moveToRegistrationForm();
            registrationFormPage.EnterFirstName(faker.name().firstName());
            registrationFormPage.EnterLastName((faker.name().lastName()));
            registrationFormPage.clickOnGender();
            registrationFormPage.EnterStreetAddress(faker.address().streetAddress());
            registrationFormPage.EnterApartmentAddress(faker.address().secondaryAddress());
            registrationFormPage.EnterCity(faker.address().city());
            registrationFormPage.EnterPostalCode(faker.address().zipCode());
            registrationFormPage.EnterState(faker.address().state());
            registrationFormPage.SelectCountry(faker.address().country());
            registrationFormPage.EnterEmail(faker.internet().emailAddress());
            registrationFormPage.EnterDateOfDemo(this.driver);
            registrationFormPage.EnterMoblieNumber(faker.phoneNumber().phoneNumber().replace("-","").replace(".",""));
            registrationFormPage.EnterCourseOfInterest();
            registrationFormPage.Enter_your_query(faker.lorem().sentence());
            registrationFormPage.EnterVerficationCode();
            transactionDetailsPage = registrationFormPage.ClickOnSubmit();

            String transactionID = transactionDetailsPage.getTransactionID();
            Assert.assertEquals(transactionID.equals(transactionDetailsPage.getTransactionID()), Pattern.matches("^\\d{10}$", transactionID));
            System.out.println("FirstName"+registrationFormPage.getFirstName());
            System.out.println("LastName"+registrationFormPage.getLastName());
            System.out.println("Email"+registrationFormPage.getEmail());
            System.out.println("MobileNumber"+registrationFormPage.getMobileNumber());
            System.out.println("CourseOfInterest"+registrationFormPage.getCourseOfInterest());
            System.out.println("VerificationCode"+registrationFormPage.getApartmentAddress());
            System.out.println("Enter_your_query"+registrationFormPage.getEnter_your_query());
            System.out.println("TransactionID"+transactionDetailsPage.getTransactionID());
            System.out.println("city"+registrationFormPage.getCity());
            System.out.println("streetAddress"+registrationFormPage.getStreetAddress());
            System.out.println("apartmentAddress"+registrationFormPage.getApartmentAddress());
            System.out.println("postalCode"+registrationFormPage.getPostalCode());
        }catch (Exception ex){
            Reporter.log(ex.getMessage()+"");
            String fp=su.captureScreenshot(driver);
            Reporter.log(
                    "<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a><br>");
            sa.assertTrue(false);
        }
    }
    @Test(priority = 4)
    public void Verify_RegisterFormWithMandataryData() throws Throwable {
        try {
            homePage = new HomePage(driver, new FluentWait<RemoteWebDriver>(driver));
            homePage.moveToDemoSite();
            homePage.moveToPracticeAutomation();
            registrationFormPage = homePage.moveToRegistrationForm();
            registrationFormPage.EnterFirstName(faker.name().firstName());
            registrationFormPage.EnterLastName((faker.name().lastName()));
            registrationFormPage.EnterEmail(new Properties().getProperty("validEmail"));
            transactionDetailsPage=registrationFormPage.ClickOnSubmit();
            String transactionID = transactionDetailsPage.getTransactionID();
            Assert.assertEquals(transactionID.equals(transactionDetailsPage.getTransactionID()), Pattern.matches("^\\d{10}$", transactionID));

        }catch (Exception ex){
            Reporter.log(ex.getMessage()+"");
            String fp=su.captureScreenshot(driver);
            Reporter.log(
                    "<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a><br>");
            sa.assertTrue(false);
        }

    }
    //data provider method data driven Testing
    @DataProvider(name = "RegisterFormTestData")
    public Object[][]method1(){
        Object[][] x=new Object[][]{
                {"Sreenu","Anumandla","chennai center","chennai zone","chennai","Tamilnadu","600001","India","sreenuanumaa45@mail.com","1234567890","hi hello "},
                {"Sreenu","Anumandla","chennai center","chennai zone","chennai","Tamilnadu","600001","India","sreenuanumaa45@mail.com","1234567890","hi hello "},
                {"veeresh","anumandla","chennai center","chennai zone","chennai","Tamilnadu","600001","India","sreenuanumaa45@mail.com","1234567890","hi hello "}
        };
        return x;
    }


  @AfterClass
  public void AfterClass_Cleanup() throws ATUTestRecorderException {
    //  recorder.stop();
  }

  @AfterMethod
    public void  closesite() {
        driver.close();
    }


}

