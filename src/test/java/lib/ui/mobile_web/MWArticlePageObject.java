package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        TITLE_SECOND = "id:JavaScript";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch button";

        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        SECOND_ARTICLE_TITLE = "JavaScript";
        SECOND_ARTICLE_ID = "id:JavaScript";
    };

    public MWArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
