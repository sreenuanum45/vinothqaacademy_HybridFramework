package pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import projectutility.DataPicker;
import projectutility.ScreenShotUtility;
import utilities.ActionsUtility;
import utilities.ImagesCollection;
import utilities.LinksUtility;


import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationFormPage {
  public   RemoteWebDriver driver;
   public ImagesCollection imagesCollection;
    public LinksUtility linksUtility;
    public List<WebElement> images;
    public ActionsUtility actionsUtility;
    public ScreenShotUtility screenShotUtility;
  public   FluentWait<RemoteWebDriver> wait;
    public RegistrationFormPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
        this.wait=wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement firstName;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    private WebElement lastName;
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    private WebElement gender;
    @FindBy(xpath = "(//input[@type='text'])[5]")
    private WebElement StreetAddress;
    @FindBy(xpath = "(//input[@type='text'])[6]")
    private WebElement ApartmentAddress;
    @FindBy(xpath = "(//input[@type='text'])[7]")
    private WebElement City;
    @FindBy(xpath = "(//input[@type='text'])[8]")
    private WebElement State;
    @FindBy(xpath = "(//input[@type='text'])[9]")
    private WebElement PostalCode;
   @FindBy(xpath = "(//span[@role='combobox'])[1]")
   private WebElement Country;
   @FindBy(xpath = "//input[@type='search']")
   private WebElement ShadowHostOf_SearchCountry;
   @FindBy(xpath = "//li[@role='option'][1]")
   private  WebElement SelectCountry;
   @FindBy(xpath = "//input[@type='search']")
   private  WebElement EnterCountryName;
   @FindBy(xpath = "(//ul//li[@role='option'])[1]")
   private  WebElement EnterCountryNameSelect;
   @FindBy(xpath = "//input[@type='email']")
   private WebElement Email;
@FindBy(xpath = "(//input[@type='text'])[10]")
private  WebElement DateOfDemo;
@FindBy(xpath = "//a//span[text()='Prev']")
private  WebElement Datepicker_Previous;
@FindBy(xpath = "//a//span[text()='Next']")
private  WebElement Datepicker_Next;
@FindBy(linkText = "11")
private  WebElement SelectDate;;
@FindBy(xpath = "(//span[@role='textbox'])[2]")
private  WebElement Convenient_Time;


    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    private  WebElement Convenient_Time_HH;
    @FindBy(xpath = "//input[@type='search']")
    private  WebElement EnterConvenient_Time_HH;
    @FindBy(xpath = "//ul//li[@aria-selected='true']")
    private  WebElement SelectConvenient_Time_HH;

    @FindBy(xpath = "(//span[@role='textbox'])[3]")
    private  WebElement Convenient_Time_MM;
    @FindBy(xpath = "(//input[@type='text'])[11]")
    private  WebElement MobileNumber;
    @FindBy(xpath = "(//span//input[@type='checkbox'])")
    private  List<WebElement> CourseOfInterest;
    @FindBy(xpath = "//textarea")
    private  WebElement Enter_your_query;

    public WebElement getFirstName() {
        return firstName;
    }
    public WebElement getLastName() {
        return lastName;
    }
    public WebElement getStreetAddress() {
        return StreetAddress;
    }
    public WebElement getApartmentAddress() {
        return ApartmentAddress;
    }
    public WebElement getCity() {
        return City;
    }
    public WebElement getState() {
        return State;
    }

    public WebElement getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(WebElement postalCode) {
        PostalCode = postalCode;
    }

    public WebElement getCountry() {
        return Country;
    }

    public void setCountry(WebElement country) {
        Country = country;
    }

    public WebElement getShadowHostOf_SearchCountry() {
        return ShadowHostOf_SearchCountry;
    }

    public void setShadowHostOf_SearchCountry(WebElement shadowHostOf_SearchCountry) {
        ShadowHostOf_SearchCountry = shadowHostOf_SearchCountry;
    }

    public WebElement getSelectCountry() {
        return SelectCountry;
    }

    public void setSelectCountry(WebElement selectCountry) {
        SelectCountry = selectCountry;
    }

    public WebElement getEnterCountryName() {
        return EnterCountryName;
    }

    public void setEnterCountryName(WebElement enterCountryName) {
        EnterCountryName = enterCountryName;
    }

    public WebElement getEnterCountryNameSelect() {
        return EnterCountryNameSelect;
    }

    public WebElement getEmail() {
        return Email;
    }
    public WebElement getDatepicker_Next() {
        return Datepicker_Next;
    }

    public void setDatepicker_Next(WebElement datepicker_Next) {
        Datepicker_Next = datepicker_Next;
    }

    public WebElement getSelectDate() {
        return SelectDate;
    }
    public WebElement getConvenient_Time() {
        return Convenient_Time;
    }
 public WebElement getConvenient_Time_HH() {
        return Convenient_Time_HH;
    }
    public WebElement getEnterConvenient_Time_HH() {
        return EnterConvenient_Time_HH;
    }

    public WebElement getConvenient_Time_MM() {
        return Convenient_Time_MM;
    }
    public WebElement getMobileNumber() {
        return MobileNumber;
    }
    public List<WebElement> getCourseOfInterest() {
        return CourseOfInterest;
    }
    public WebElement getEnter_your_query() {
        return Enter_your_query;
    }
    public WebElement getFirstNameErrorMsg() {
        return firstNameErrorMsg;
    }
    public WebElement getLastNameErrorMsg() {
        return lastNameErrorMsg;
    }
    public WebElement getEmailErrorMsg() {
        return EmailErrorMsg;
    }
    @FindBy(xpath = "(//input[@type='text'])[12]")
    private  WebElement VerficationCode;
    @FindBy(xpath = "(//span//label)[last()]")
    private  WebElement VerificationText;

    @FindBy(xpath = "//input[@type='submit']")
    private  WebElement Submit;
    ////
   // Error msg elements
    @FindBy(xpath = "(//li//label[text()='This field is required.'])[1]")
    private WebElement firstNameErrorMsg;

    @FindBy(xpath = "(//li//label[text()='This field is required.'])[2]")
    private WebElement lastNameErrorMsg;

    @FindBy(xpath = "(//li//label[text()='This field is required.'])[3]")
    private WebElement EmailErrorMsg;
    public void validateFirstNameErrorMsg() throws InterruptedException {
        if(firstNameErrorMsg.isDisplayed()){

            Reporter.log("First name error msg is displayed");
            Thread.sleep(2000);
            Assert.assertTrue(firstNameErrorMsg.getText().equals(new Properties().getProperty("ExpectedFirstnameErrorMessage")));
        }
        else{
            System.out.println("First name error msg is not displayed");
        }
    }
    public void validateLastNameErrorMsg(){
        if(lastNameErrorMsg.isDisplayed()){
            Reporter.log("Last name error msg is displayed",true);
            Assert.assertEquals(lastNameErrorMsg.getText(),new Properties().getProperty("lastNameErrorMsg"));
        }
        else{
            System.out.println("Last name error msg is not displayed");
        }
    }
    public void validateEmailErrorMsg(){
        if(EmailErrorMsg.isDisplayed()){
            Reporter.log("Email error msg is displayed",true);
            Assert.assertEquals(EmailErrorMsg.getText(),new Properties().getProperty("EmailErrorMsg"));
        }
        else{
            System.out.println("Email error msg is not displayed");
        }
    }


    public void EnterFirstName(String data){
        firstName.sendKeys(data);
    }
    public void EnterLastName(String data){
        lastName.sendKeys(data);
    }
    public void clickOnGender(){
        gender.click();
    }
    public void EnterStreetAddress(String data){
        StreetAddress.sendKeys(data);
    }
    public void EnterApartmentAddress(String data){
        ApartmentAddress.sendKeys(data);
    }
    public void EnterCity(String data){
        City.sendKeys(data);
    }
    public void EnterState(String data){
        State.sendKeys(data);
    }
    public void EnterPostalCode(String data){
        PostalCode.sendKeys(data);
    }
    public void SelectCountry(String country){
        Country.click();
        EnterCountryName.sendKeys(country);
        EnterCountryNameSelect.click();
    }
    public  void EnterEmail(String email){
        Email.sendKeys(email);
    }
    public  void EnterDateOfDemo(RemoteWebDriver driver) throws Throwable {
        DateOfDemo.click();
        DataPicker.dateSelector(DateOfDemo,driver);
    }
    public  void EnterConvenientTime(RemoteWebDriver driver) throws Throwable {
driver.executeScript("arguments[0].scrollintoview", Convenient_Time_HH);
//Convenient_Time_HH.click();
        wait.until(ExpectedConditions.elementToBeClickable(Convenient_Time_HH));
        Thread.sleep(1000);
        EnterConvenient_Time_HH.sendKeys("11");
        Thread.sleep(1000);
        SelectConvenient_Time_HH.click();
        Convenient_Time_MM.click();
    }
    public  void EnterMoblieNumber(String Number){
        wait.until(ExpectedConditions.elementToBeClickable(MobileNumber));
        MobileNumber.sendKeys(Number);
    }
    public void EnterCourseOfInterest(){
  wait.until(ExpectedConditions.elementToBeClickable(CourseOfInterest.get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CourseOfInterest.get(2))).click();

    }
    public void Enter_your_query(String data){
        wait.until(ExpectedConditions.elementToBeClickable(Enter_your_query)).sendKeys(data);
    }
    public void
    EnterVerficationCode() throws InterruptedException {
        String data=wait.until(ExpectedConditions.visibilityOf(VerificationText)).getText();
        String VerificationCode=extractTransactionID(data);
       System.out.println("VerificationCode :"+VerificationCode);
        driver.executeScript("arguments[0].scrollintoview", VerficationCode);
        wait.until(ExpectedConditions.elementToBeClickable(VerficationCode)).sendKeys(VerificationCode);
    }
    public TransactionDetailsPage ClickOnSubmit(){
      wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
      return new TransactionDetailsPage(driver,wait);
    }
  public  void Registrationform(String Firstname,String Lastname,String streetAddress,String apartmentAddress,String cityname,String statename,String postalcodeNumber,String countryName,String email_id,String mobileNumber,String enter_your_query
       ) throws Throwable {
       wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(Firstname);
       wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(Lastname);
       wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
       wait.until(ExpectedConditions.visibilityOf(StreetAddress)).sendKeys(streetAddress);
       wait.until(ExpectedConditions.visibilityOf(ApartmentAddress)).sendKeys(apartmentAddress);
       wait.until(ExpectedConditions.visibilityOf(City)).sendKeys(cityname);
       wait.until(ExpectedConditions.visibilityOf(State)).sendKeys(statename);
       wait.until(ExpectedConditions.visibilityOf(PostalCode)).sendKeys(postalcodeNumber);
       wait.until(ExpectedConditions.elementToBeClickable(Country)).click();
       wait.until(ExpectedConditions.visibilityOf(EnterCountryName)).sendKeys(countryName);
       wait.until(ExpectedConditions.elementToBeClickable(EnterCountryNameSelect)).click();
       wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(email_id);
       wait.until(ExpectedConditions.elementToBeClickable(DateOfDemo)).click();
      DataPicker.dateSelector(DateOfDemo,driver);
      wait.until(ExpectedConditions.visibilityOf(MobileNumber)).sendKeys(mobileNumber);
      wait.until(ExpectedConditions.elementToBeClickable(CourseOfInterest.get(0))).click();
      wait.until(ExpectedConditions.elementToBeClickable(CourseOfInterest.get(2))).click();
     wait.until(ExpectedConditions.visibilityOf(Enter_your_query)).sendKeys(enter_your_query);
      String data=wait.until(ExpectedConditions.visibilityOf(VerificationText)).getText();
      System.out.println("VerificationCode:"+data);
      driver.executeScript("arguments[0].scrollintoview", VerficationCode);
      data=extractTransactionID(data);
      wait.until(ExpectedConditions.elementToBeClickable(VerficationCode)).sendKeys(data);
      wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();


  }
    public static String extractTransactionID(String input) {
        // Define a regex pattern to match the transaction ID (sequence of digits)
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String found = matcher.group();
            // Assuming the transaction ID is the last number in the string
            // Or you can check if the found string meets specific criteria
            return found;
        }
        return null;
    }

}
