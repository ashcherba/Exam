package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleMainPage;
import page.GoogleSearchResultsPage;
import page.GoogleSecondSearchResultsPage;

import java.util.List;

public class GoogleSearchTestOnSecondPage extends BaseTest {
    /**
     * verify that list of search results contains 10 elements on the second results page
     * verify that each search result card contains "Selenium" word
     */
    @Test
    public void searchTestOnSecondPage(){
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleSearchResultsPage searchResultsPage = mainPage.searchForTerm("Selenium");
        GoogleSecondSearchResultsPage secondResultsPage = searchResultsPage.goToTheNextPage();
        List<String> results = secondResultsPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        for(String result: results) {
            Assert.assertTrue(result.toLowerCase().contains("selenium"),
                    "Searchterm "+"'Selenium'"+ " not found in cart");
        }
    }
}
