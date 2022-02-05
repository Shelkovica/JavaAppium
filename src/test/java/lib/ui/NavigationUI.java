package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject
{
    protected static  String
        MY_LISTS_LINK,
        OPEN_NAVIGATION;

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
}
