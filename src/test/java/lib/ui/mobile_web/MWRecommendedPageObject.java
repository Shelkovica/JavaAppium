package lib.ui.mobile_web;

import lib.ui.RecommendedPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWRecommendedPageObject extends RecommendedPageObject {
    static {
        RECOMMENDED_TITLE = "css:h2.appointment__title";
        COMPLETED_ELEMENT = "xpath://a[@href='/completed']";
        RECOMMENDED_ELEMENT = "xpath://a[@href='/recommended']";
    }

    public MWRecommendedPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
