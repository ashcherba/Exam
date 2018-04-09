package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSecondSearchResultsPage extends GoogleSearchResultsPage {

    @FindBy(id = "resultStats")
    private WebElement numberOfResutlsOnSecPage;
    /**
     * Constructor of GoogleSecondSearchResultsPage class that takes WebDriver instance from GoogleBasePage class
     * and initialise GoogleSecondSearchResultsPage WebElements via PageFactory.
     * @param driver - WebDriver instance that was initialised on GoogleBasePage
     */
    public GoogleSecondSearchResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * get text from the results status block
     * @return information about number of the total search results and number of current page
     */
    public String getStatusOfResultsOnSecPage(){
        String resultsStatusOnSecondPage = numberOfResutlsOnSecPage.getText();
        return resultsStatusOnSecondPage;
    }
}
