package lib.ui;

import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class RecommendedPageObject extends MainPageObject{
    protected static  String
            RECOMMENDED_TITLE,
            COMPLETED_ELEMENT,
            RECOMMENDED_ELEMENT;


    public RecommendedPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }


    @Step("recommended Title Is Present")
    public void recommendedTitleIsPresent(String locator)
    {
        this.waitForElementPresent(RECOMMENDED_TITLE, "Cannot present Recommended title", 5);
    }


    @Step("get Page Title")
    public String getPageTitle()
    {
        WebElement title_element = waitForElementPresent(RECOMMENDED_TITLE, "Cannot present Recommended title", 10);
        System.out.println(title_element.getText());
        return title_element.getText();
    };

    @Step("completed Title Is Present")
    public void completedTitleIsPresent()
    {
        this.waitForElementAndClick(COMPLETED_ELEMENT, "Cannon open completed page", 5);
        this.waitForElementPresent(RECOMMENDED_TITLE, "Cannot present completed title", 5);
    }

    @Step("recommended Title Is Present")
    public void recommendedTitleIsPresent()
    {
        this.waitForElementAndClick(RECOMMENDED_ELEMENT, "Cannon open completed page", 5);
        this.waitForElementPresent(RECOMMENDED_TITLE, "Cannot present Recommended title", 5);
    }

}
