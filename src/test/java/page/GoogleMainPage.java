package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


public class GoogleMainPage extends GoogleBasePage {
    @FindBy(id = "lst-ib")
    private WebElement searchInputField;

    @FindBy(name = "btnK")
    private WebElement searchInGoogleButton;

    @FindBy(xpath = "//div[@class='sbsb_g']//input[@value='Поиск в Google']")
    private WebElement searchButtonOnTheDropDownList;

    @FindBy(xpath = "//ul[@class='sbsb_b']")
    private WebElement dropDownListOfSimilarSearchTerms;

    @FindBy(className = "sbsb_b")
    private WebElement listOfSimilarSearchTerms;

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
        if (searchInGoogleButton.isEnabled()) {
            searchInGoogleButton.submit();
        } else {
            waitUntilElementIsVisible(searchButtonOnTheDropDownList);
            searchButtonOnTheDropDownList.click();
        }
        return new GoogleSearchResultsPage(driver);
    }
}
