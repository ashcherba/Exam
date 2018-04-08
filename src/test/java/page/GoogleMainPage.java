package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleMainPage extends GoogleBasePage {
    WebDriver driver;

    @FindBy(id = "lst-ib")
    private WebElement searchInputField;

    @FindBy(name = "btnK")
    private WebElement searchInGoogleButton;

    /**
     * Constructor of GoogleMainPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleMainPage WebElements via PageFactory.
     * @param driver - WebDriver instance that was initialised on GoogleBasePage
     */
    public GoogleMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Searches for elements by entered specific search term
     * @param searchTerm - text value for searching into google
     * @return first page of search results
     */
    public GoogleSearchResultsPage searchForTerm (String searchTerm){
        searchInputField.sendKeys(searchTerm);
        waitUntilElementIsClickable(searchInGoogleButton);
        searchInGoogleButton.submit();
        return new GoogleSearchResultsPage(driver);
    }
}
