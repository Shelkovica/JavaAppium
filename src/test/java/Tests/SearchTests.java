package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

@Epic("Tests for search")
public class SearchTests extends CoreTestCase
{

    @Test
    @Ignore
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Test cancel search")
    @Description("We open search and then close it")
    @Step("Starting test testCancelSearch")
    @Severity(value = SeverityLevel.MINOR)
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisAppear();
    };

    @Test
    @Ignore
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Test text in search input")
    @Description("We open search and assert placeholder")
    @Step("Starting test testElementText")
    @Severity(value = SeverityLevel.MINOR)
    public void testElementText()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String errorMessage = "Text in element with error";
        String resultAssert = SearchPageObject.assertTextInSearchInput(errorMessage);
        Assert.assertEquals(errorMessage, "Ok", resultAssert);
    }

    @Test
    @Ignore
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Test search result after search cancel")
    @Description("We search article, cancel the search and check empty page")
    @Step("Starting test testResultAfterSearchCancel")
    @Severity(value = SeverityLevel.MINOR)
    public void testResultAfterSearchCancel()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        Assert.assertTrue("no find article",  SearchPageObject.getArticleCountOnPage()>0);
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.waitForEmptyResultMessage();
    };

    @Test
    @Ignore
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Test search result contains search text")
    @Description("We search article, assert 3 first results contains search text")
    @Step("Starting test testSearchResult")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearchResult()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String string_search = "Java";
        SearchPageObject.typeSearchLine(string_search);
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
        List<WebElement> count_article = SearchPageObject.getArticlesTitle();
        for(WebElement c_article:count_article) {
            String title_article = c_article.getText();
            Assert.assertTrue(
                    "some article in search result not contain "+string_search,
                    title_article.toLowerCase().contains(string_search.toLowerCase()));
        }
    }

    @Test
    @Ignore
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Test search result contains some article")
    @Description("We search article, assert search results contains above 1 article")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(value = SeverityLevel.MINOR)
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results>0
        );
    };

    @Test
    @Ignore
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Test empty search result ")
    @Description("We search incorrect text, assert empty page")
    @Step("Starting test testAmountOfEmptySearch")
    @Severity(value = SeverityLevel.MINOR)
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "dfdfsfsste";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}
