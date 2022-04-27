package lib.ui.factories;

import lib.ui.RecommendedPageObject;
import lib.ui.mobile_web.MWRecommendedPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RecommendedPageObjectFactory
{
    public static RecommendedPageObject get(RemoteWebDriver driver)
    {

            return new MWRecommendedPageObject(driver);
            }

}
