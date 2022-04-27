package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject
{
    protected static  String
        MY_LISTS_LINK,
        OPEN_NAVIGATION,
        OPEN_EDUCATION,
        OPEN_AUDITS,
        OPEN_LIBRARY,
        OPEN_COMMUNICATION,
        OPEN_REPORTS,
        OPEN_MENU_CREATE_DOCUMENTS,
        SELECT_MENU_CREATE_AUDIT,
        SELECT_MENU_CREATE_FOLDER,
        SELECT_MENU_CREATE_COURSE,
        SELECT_MENU_CREATE_TEST,
        SELECT_MENU_CREATE_EXAM;


    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("open Navigation")
    public void openNavigation()
    {
        if( lib.Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "cannot find and lick open navigation button", 5
            );
        } else {
            System.out.println("Method openNavigation() do nothing for platform "+ lib.Platform.getInstance().getPlatformVar());
        }
    }

    @Step("click My Lists")
    public void clickMyLists()
    {
        if (lib.Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        }
    }

    @Step("open Library")
    public void openLibrary()
    {
        if( lib.Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_LIBRARY, "cannot find and lick open navigation button", 5
            );
        } else {
            System.out.println("Method openLibrary() do nothing for platform "+ lib.Platform.getInstance().getPlatformVar());
        }
    }

    @Step("open menu create documents")
    public void openMenuCreatedDocuments()
    {
        if( lib.Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_MENU_CREATE_DOCUMENTS, "cannot find and lick open menu create documents", 5
            );
        } else {
            System.out.println("Method openMenuCreatedDocuments do nothing for platform "+ lib.Platform.getInstance().getPlatformVar());
        }
    }

    @Step("open page create audit")
    public void openPageCreateAudit()
    {
        if( lib.Platform.getInstance().isMw()){
            this.waitForElementAndClick(SELECT_MENU_CREATE_AUDIT, "cannot find and lick open menu create audit", 5
            );
        } else {
            System.out.println("Method openMenuCreatedDocuments do nothing for platform "+ lib.Platform.getInstance().getPlatformVar());
        }
    }


}
