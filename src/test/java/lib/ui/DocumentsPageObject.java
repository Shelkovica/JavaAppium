package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class DocumentsPageObject extends MainPageObject{
    protected static  String
            DOCUMENT_TITLE,
            EMPTY_AREA,
            EMPTY_AREA_QUESTION,
            LINK_CREATE_QUESTION,
            QUESTION_TITLE,
            QUESTION_FIRST_ANSWER,
            QUESTION_SECOND_ANSWER,
            TAB_ACTIVE;

    public DocumentsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


    @Step("set Document Title")
    public void setDocumentTitle(String title)
    {
        this.waitForElementAndSendKeys(DOCUMENT_TITLE, title, "Cannot find title input", 10);
        this.waitForElementAndClick(EMPTY_AREA, "Cannot find empty area", 10);
    }

    @Step("click On Create Question")
    public void clickOnCreateQuestion()
    {
        this.waitForElementAndClick(LINK_CREATE_QUESTION, "Cannot find link for create question", 5);
    }

    @Step("set Question Title")
    public void setQuestionTitle(String title) throws InterruptedException {
       //this.waitForElementPresent(QUESTION_TITLE, "Cannot find question title input");
       this.waitForElementAndClick(EMPTY_AREA_QUESTION,"Cannot find question area", 5);
        this.waitForElementAndClick(QUESTION_TITLE,"Cannot find question title input", 5);
        Thread.sleep(5000);
        this.waitForElementAndClick(QUESTION_TITLE,"Cannot find question title input", 5);
        this.waitForElementAndClear(QUESTION_TITLE, "Cannot clear title of question", 5);
        this.waitForElementAndSendKeys(QUESTION_TITLE, title, "Cannot find question title input", 5);
    }

    @Step("set First Answer")
    public void setFirstAnswer(String answer) throws InterruptedException {
        Thread.sleep(5000);
        this.waitForElementAndClick(QUESTION_FIRST_ANSWER,"Cannot find answer question input", 5);
        this.waitForElementAndClick(QUESTION_FIRST_ANSWER,"Cannot find answer question input", 5);
        this.waitForElementAndClear(QUESTION_FIRST_ANSWER, "Cannot clear answer of question", 5);
        this.waitForElementAndSendKeys(QUESTION_FIRST_ANSWER, answer, "Cannot find answer input", 10);
    }

    @Step("set Second Answer")
    public void setSecondAnswer(String answer) throws InterruptedException {        Thread.sleep(5000);
        this.waitForElementAndClick(QUESTION_SECOND_ANSWER,"Cannot find answer question input", 5);
        this.waitForElementAndClick(QUESTION_SECOND_ANSWER,"Cannot find answer question input", 5);
        this.waitForElementAndClear(QUESTION_SECOND_ANSWER, "Cannot clear answer of question", 5);
        this.waitForElementAndSendKeys(QUESTION_SECOND_ANSWER, answer, "Cannot find answer input", 10);
    }

    @Step("get Active Tab Title")
    public String getActiveTabTitle()
    {
        WebElement element = waitForElementPresent(TAB_ACTIVE, "Cannot view active tab", 5);
        return element.getText();
    }

}

