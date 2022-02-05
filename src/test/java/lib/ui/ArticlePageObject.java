package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{

    protected  static String
        TITLE,
        TITLE_SECOND,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON,
        FOLDER_BY_NAME_TPL,
        SECOND_ARTICLE_TITLE,
        ARTICLE_NOTE,
        SECOND_ARTICLE_ID;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return  FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Wait title for article")
    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    @Step("Wait title for second article")
    public WebElement waitForTitleSecondElement()
    {
        return this.waitForElementPresent(TITLE_SECOND, "Cannot find article title on page!", 15);
    }

    @Step("get Articles Title")
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        screenshot(this.takeScreenshot("Article Title"));
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    @Step("get second Articles Title")
    public String getArticleSecondTitle()
    {
        WebElement title_element = waitForTitleSecondElement();
        screenshot(this.takeScreenshot("Article Title"));
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        }else {
            return title_element.getText();
        }

    }

    @Step("swipe To Footer")
    public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()){
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                40
        );} else if(Platform.getInstance().isIOS()) {
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else {
            this.scrollWebPageTitleElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }
    }

    @Step("add Article To My List")
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementPresent(
                TITLE,
                "Cannot find article title",
                15

        );

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got It' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of article folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press ok button",
                5
        );

    };

    @Step("add Second Article To My List")
    public void addSecondArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                5
        );
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find options to add article to old reading list",
                5
        );
    }

    @Step("close Article")
    public void closeArticle()
    {
       if(Platform.getInstance().isAndroid()||(Platform.getInstance().isIOS())){
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );}
       else {
           System.out.println("Method closeArticle() do nothing for platform "+Platform.getInstance().getPlatformVar());
       }
    }


    public String getTitleArticleFromMyList()
    {
      if (Platform.getInstance().isAndroid()){
        return this.waitForElementAndGetAttribute(
                SECOND_ARTICLE_TITLE,
                "text",
                "Cannot find title of article in list",
                15
        );} else if (Platform.getInstance().isIOS()){
          return SECOND_ARTICLE_TITLE;}
      else{  WebElement second_title = waitForElementPresent(SECOND_ARTICLE_TITLE, "Cannot find article title on page!", 15);
                String title = second_title.getText();

          return title;
      }
    };

    @Step("open Article")
    public void openArticle()
    {if (Platform.getInstance().isAndroid() || Platform.getInstance().isMw()) {
        this.waitForElementAndClick(
                SECOND_ARTICLE_TITLE,
                "Cannot open article",
                5
        );} else if (Platform.getInstance().isIOS()){
        this.openArticleInList();
    }
    }

    @Step("open Article in my list")
    public void openArticleInList()
    {

        this.waitForElementAndClick(
                SECOND_ARTICLE_ID,
                "Cannot open article in list",
                5
        );
    }

    @Step("assert Title Present")
    public void assertTitlePresent()
    {
        this.assertElementPresent(
                TITLE,
                "article title is not present"
        );
    }

    @Step("remove Article from Saved If It Added")
    public void removeArticleFromSavedIfItAdded()
    {
        if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot clock button to remove an article from saved",
                    1);
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }
    }

    @Step("add Articles To My Saved")
    public void addArticlesToMySaved()
    {
        if (Platform.getInstance().isMw()){this.removeArticleFromSavedIfItAdded();}
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

    @Step("get Article Note")
    public String getArticleNote()
    {
        WebElement note = waitForElementPresent(ARTICLE_NOTE, "Cannot find note", 5);
        return  note.getText();
    }
}
