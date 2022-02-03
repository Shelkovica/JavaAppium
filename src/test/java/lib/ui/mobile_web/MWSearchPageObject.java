package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        // SEARCH_CANCEL_BUTTON = "id:close";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        //XCUIElementTypeStaticText[@name="Java (programming language)"]
        SEARCH_RESULT_BY_SYBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(),'{SUBSTRING}')]";

        // SEARCH_RESULT_BY_SYBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULTS_ELEMENT = "css:p.without-results";


        SEARCH_INPUT_TEXT_ELEMENT = "id:org.wikipedia:id/search_src_text";
        SEARCH_INPUT_TEXT = "Search…";
        SEARCH_RESULT_TITLE_ARTICLE = "id:org.wikipedia:id/page_list_item_title";
        SEARCH_EMPTY_ELEMENT = "id:org.wikipedia:id/search_empty_message";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
