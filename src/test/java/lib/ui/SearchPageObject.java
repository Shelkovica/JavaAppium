package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject{

     protected static  String
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_CANCEL_BUTTON,
        SEARCH_RESULT_BY_SYBSTRING_TPL,
        SEARCH_RESULT_ELEMENT,
        SEARCH_EMPTY_RESULTS_ELEMENT,
        SEARCH_INPUT_TEXT_ELEMENT,
        SEARCH_INPUT_TEXT,
        SEARCH_RESULT_TITLE_ARTICLE,

        SEARCH_EMPTY_ELEMENT;


    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SYBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    @Step("Initializing the search field")
    public void initSearchInput()
    {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);

    }

    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button!", 5);
    }

    @Step("Waiting for search cancel button to disappear")
    public void waitForCancelButtonToDisAppear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present!", 5);
    }

    @Step("Clicking button to cancel search result")
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    @Step("Typing '{search_line}' to the search line")
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"Cannot find and type into search input", 5);
    }

    @Step("Waiting for search result: '{substring}'")
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring "+substring);
    }

    @Step("Waiting for search result and select an article by substring '{substring}' in article title")
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring "+substring,10);
    }

    @Step("Getting amount of found articles")
    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    @Step("Waiting for empty result label")
    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULTS_ELEMENT, "Cannot find empty result element", 15);
    }

    @Step("Making sure there are no results for the search")
    public void assertThereIsNoResultOfSearch()
    {
       this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any results");
    }

    @Step("assert Text In Search Input")
    public String assertTextInSearchInput(String errorMessage)
    {
        return this.assertElementHasText(
                SEARCH_INPUT_TEXT_ELEMENT,
                SEARCH_INPUT_TEXT,
                errorMessage
        );
    }

    @Step("get Article Count On Page")
    public int getArticleCountOnPage()
    {
        List count_article = driver.findElementsById(SEARCH_RESULT_TITLE_ARTICLE);
        return  count_article.size();
    }

    @Step("wait For Empty Result Message")
    public void waitForEmptyResultMessage()
    {
       this.waitForElementPresent(SEARCH_EMPTY_ELEMENT, "Search is not empty",5);
    }

    @Step("get Articles Title")
    public List getArticlesTitle()
    {
        List <WebElement> count_article = driver.findElementsByXPath(SEARCH_RESULT_TITLE_ARTICLE);
        return count_article;
    }

}
