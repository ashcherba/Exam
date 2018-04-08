package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleBasePage {
    WebDriver driver;

    /**
     *Constructor of GoogleBasePage class which takes Web Driver instance
     * @param driver - WebDriver instance
     */
    public GoogleBasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Wait until web element starts to be clickable
     * @param webElement - Web Element to Wait for
     */
    public void waitUntilElementIsClickable (WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Wait until WebElement appears on the Web Page
     * @param webElement - Web Element to Wait for
     */
    public void waitUntilElementIsVisible (WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(visibilityOf(webElement));
    }
}
