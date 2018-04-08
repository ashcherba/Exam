package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {
    @FindBy(xpath = "//*[@class='srg']//h3/a")
    private List<WebElement> searchResults;

    @FindBy(id = "pnnext")
    private WebElement linkToTheNextPage;

    @FindBy(id = "resultStats")
    private WebElement numberOfResutls;

    /**
     * Constructor of GoogleSearchResultsPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleSearchResultsPage WebElements via PageFactory.
     * @param driver - WebDriver instance that was initialised on GoogleBasePage
     */
    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * The method that goes through each search result card and gets the card title
     * which records in the special list - resultsStringList
     * @return list of card titles from the search result
     */
    public List<String> getResults(){
        waitUntilElementIsVisible(numberOfResutls);
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", result);
            String cardTitle = result.getText().toLowerCase();
            resultsStringList.add(cardTitle);
        }
        return resultsStringList;
    }

    /**
     * Clicks on the link to the next page
     * @return the next page pof Search results
     */
    public GoogleSecondSearchResultsPage goToTheNextPage(){
        waitUntilElementIsVisible(numberOfResutls);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", linkToTheNextPage);
        linkToTheNextPage.click();
        return new GoogleSecondSearchResultsPage(driver);
    }
}
