package lib.ui;

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

    public void recommendedTitleIsPresent(String locator)
    {
        this.waitForElementPresent(RECOMMENDED_TITLE, "Cannot present Recommended title", 5);
    }

    public String getPageTitle()
    {
        WebElement title_element = waitForElementPresent(RECOMMENDED_TITLE, "Cannot present Recommended title", 10);
        System.out.println(title_element.getText());
        return title_element.getText();
    };

    public void completedTitleIsPresent()
    {
        this.waitForElementAndClick(COMPLETED_ELEMENT, "Cannon open completed page", 5);
        this.waitForElementPresent(RECOMMENDED_TITLE, "Cannot present completed title", 5);
    }

    public void recommendedTitleIsPresent()
    {
        this.waitForElementAndClick(RECOMMENDED_ELEMENT, "Cannon open completed page", 5);
        this.waitForElementPresent(RECOMMENDED_TITLE, "Cannot present Recommended title", 5);
    }

}
