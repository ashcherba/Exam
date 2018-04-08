package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSecondSearchResultsPage extends GoogleSearchResultsPage {
    /**
     * Constructor of GoogleSecondSearchResultsPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleSecondSearchResultsPage WebElements via PageFactory.
     * @param driver - WebDriver instance that was initialised on GoogleBasePage
     */
    public GoogleSecondSearchResultsPage(WebDriver driver){
        super(driver);
    }
}
