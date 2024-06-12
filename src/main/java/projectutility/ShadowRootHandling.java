package projectutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static projectutility.BrowserLaunch.driver;

public class ShadowRootHandling {
    public WebElement getShadowRoot(String hostSelector) {
        WebElement shadowHost = driver.findElement(By.cssSelector(hostSelector));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);
    }

    public WebElement findElementInShadowRoot(WebElement shadowRoot, String selector) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (WebElement) jsExecutor.executeScript("return arguments[0].querySelector(arguments[1])", shadowRoot, selector);
    }

    public void interactWithShadowElement(String hostSelector, String elementSelector) {
        WebElement shadowRoot = getShadowRoot(hostSelector);
        WebElement element = findElementInShadowRoot(shadowRoot, elementSelector);
        element.click(); // or any other interaction you need
    }
}
