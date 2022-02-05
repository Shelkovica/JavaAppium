package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        TITLE_SECOND = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:a#ca-watch[title='Watch'],[title='Add this page to your watchlist']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:a#ca-watch[title='Unwatch'],[title='Remove this page from your watchlist']";

        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        SECOND_ARTICLE_TITLE = "xpath://*[@title='JavaScript']//h3";
        SECOND_ARTICLE_ID = "id:JavaScript";
        ARTICLE_NOTE = "xpath://div[@class='hatnote navigation-not-searchable plainlinks selfreference noprint']/a";
    };

    public MWArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
