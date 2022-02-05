package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObjects extends MainPageObject
{

    protected static String
        FOLDER_BY_NAME_TPL,
        ARTICLE_BY_TITLE_TPL,
        INFO_WINDOW_CLOSE,
            REMOVE_FROM_SAVED_BUTTON;

    @Step("get folder Xpath By Name '{name_of_folder}'")
    private static String getFolderXpathByName(String name_of_folder)
    {
        return  FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    @Step("get Saved Article Xpath By Title '{article_title}'")
    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return  ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    @Step("get Remove Button By Title '{article_title}'")
    private static String getRemoveButtonByTitle(String article_title)
    {
        return  REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public MyListsPageObjects(RemoteWebDriver driver){
        super(driver);
    }

    @Step("open Folder By Name '{name_of_folder}'")
    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name "+name_of_folder,
                5
        );
    }

    @Step("wait For Article To Appear By Title '{article_title}'")
    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "CAnnot find saved article by title "+article_title,
                15
        );
    }

    @Step("close Info Window In My List")
    public  void closeInfoWindowInMyList()
    {
        this.waitForElementAndClick(INFO_WINDOW_CLOSE, "Cannot find info window", 15);
    }

    @Step("wait For Article To Disappear By Title '{article_title}'")
    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title "+article_title,
                15
        );
    }

    @Step("swipe By Article '{article_title}' to Delete ")
    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
        this.swipeElementToLeft(
                article_xpath,
                "Cannon find saved article"
        );} else{
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved",
                    10
            );
        }

        if (Platform.getInstance().isIOS()) {
        this.clickElementToTheRigthUpperCorner(article_xpath, "Cannot fined saved article");
        }
        if(Platform.getInstance().isMw()) {driver.navigate().refresh();}
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
