package test;
import org.testng.Assert;
import org.testng.annotations.*;
import page.GoogleMainPage;
import page.GoogleSearchResultsPage;
import java.util.List;

public class GoogleSearchTestOnFirstPage extends BaseTest{

    /**
     * verify that list of search results contains 10 elements on the first results page
     * verify that each search result card contains "Selenium" word
     */
    @Test
    public void searchTestOnFirstPage(){
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleSearchResultsPage searchResultsPage = mainPage.searchForTerm("Selenium");
        List<String> results = searchResultsPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        for(String result: results) {
            Assert.assertTrue(result.toLowerCase().contains("selenium"),
                    "Searchterm "+"'Selenium'"+ " not found in card");
        }
    }
}
