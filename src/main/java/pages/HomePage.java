package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.ActionsUtility;
import utilities.ImagesCollection;
import utilities.LinksUtility;

import java.util.List;

public class HomePage {
    RemoteWebDriver driver;
    ImagesCollection imagesCollection;
    LinksUtility linksUtility;
    List<WebElement> images;
    ActionsUtility actionsUtility;
    FluentWait<RemoteWebDriver> wait;
    public HomePage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
        this.wait=wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//li//a[text()='Demo Sites'])[2]")
    private WebElement demoSite;
    @FindBy(xpath = "(//li//a[text()='Practice Automation'])[2]")
    private WebElement practiceAutomation;
    @FindBy(xpath = "(//li//a[text()='Registration Form'])[2]")
    private WebElement registrationForm;

    public void moveToDemoSite() {
      actionsUtility= new ActionsUtility(driver,wait);
        actionsUtility.movetoElement(demoSite);
    }

    public void moveToPracticeAutomation() {
        actionsUtility= new ActionsUtility(driver,wait);
        actionsUtility.movetoElement(practiceAutomation);
    }

    public RegistrationFormPage moveToRegistrationForm() {
        actionsUtility= new ActionsUtility(driver,wait);
        actionsUtility.movetoElement(registrationForm);
        wait.until(ExpectedConditions.visibilityOf(registrationForm)).click();
        return new RegistrationFormPage (driver,wait);
    }
}
