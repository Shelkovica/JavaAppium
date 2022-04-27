package lib.ui.mobile_web;

import lib.ui.DocumentsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWDocumentsPageObject extends DocumentsPageObject {

    static {
        DOCUMENT_TITLE = "xpath://div[@class ='title__input']/div[1]";
        LINK_CREATE_QUESTION = "xpath://div[@class='create']/div[@class='create__button']";
        QUESTION_TITLE = "xpath://div[@class='question-title question__title']/div/div";
        QUESTION_FIRST_ANSWER = "xpath://div[@class='answer'][1]//input[@class='answer__input']";
        QUESTION_SECOND_ANSWER = "xpath://div[@class='answer'][2]//input[@class='answer__input']";
        EMPTY_AREA = "css:div.create__content";
        EMPTY_AREA_QUESTION = "css:div.question__wrapper";
        TAB_ACTIVE = "css:div.tab_active";

    }

    public MWDocumentsPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
