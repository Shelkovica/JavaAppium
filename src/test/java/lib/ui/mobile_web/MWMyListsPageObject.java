package lib.ui.mobile_web;

import lib.ui.MyListsPageObjects;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObjects
{    static {
    ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(),'{TITLE}')]";
    REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'content-unstyled')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'watched')]";
    INFO_WINDOW_CLOSE = "xpath://XCUIElementTypeButton[@name='Close']";
}

    public MWMyListsPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }


}
