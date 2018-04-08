package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSecondSearchResultsPage extends GoogleSearchResultsPage {
    @FindBy(xpath = "//td[@class='cur']")
    private WebElement paginationItem;

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
     * method that verifies that second search page is loaded,
     * using web element on this page
     * @return true if specific Web Element is selected and false-if not
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = paginationItem.isSelected();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }
}
