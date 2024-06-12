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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionDetailsPage {
    RemoteWebDriver driver;
    ImagesCollection imagesCollection;
    LinksUtility linksUtility;
    List<WebElement> images;
    ActionsUtility actionsUtility;
    FluentWait<RemoteWebDriver> wait;
    public TransactionDetailsPage(RemoteWebDriver driver,FluentWait<RemoteWebDriver> wait) {
        this.wait=wait;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#messageContainer")
    private WebElement messageContainer;
    public String getMessage(){
        wait.until(ExpectedConditions.visibilityOf(messageContainer));
        return messageContainer.getText();
    }
    public String getTransactionID(){
        String data=wait.until(ExpectedConditions.visibilityOf(messageContainer)).getText();
        return extractTransactionID(data);
    }
    public static String extractTransactionID(String input) {
        // Define a regex pattern to match the phrase followed by a sequence of digits
        Pattern pattern = Pattern.compile("The Transaction ID is (\\d+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Return the first capturing group, which is the transaction ID
            return matcher.group(1);
        }
        return null;
    }

}
