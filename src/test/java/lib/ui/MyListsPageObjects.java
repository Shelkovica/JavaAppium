package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObjects extends MainPageObject
{

    protected static String
        FOLDER_BY_NAME_TPL,
        ARTICLE_BY_TITLE_TPL,
        INFO_WINDOW_CLOSE;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return  FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return  ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }


    public MyListsPageObjects(RemoteWebDriver driver){
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name "+name_of_folder,
                5
        );
    }


    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "CAnnot find saved article by title "+article_title,
                15
        );
    }

    public  void closeInfoWindowInMyList()
    {
        this.waitForElementAndClick(INFO_WINDOW_CLOSE, "Cannot find info window", 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title "+article_title,
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannon find saved article"
        );
        if (Platform.getInstance().isIOS()) {
        this.clickElementToTheRigthUpperCorner(article_xpath, "Cannot fined saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
