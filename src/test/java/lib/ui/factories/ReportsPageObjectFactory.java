package lib.ui.factories;

import lib.ui.RecommendedPageObject;
import lib.ui.ReportsPageObject;
import lib.ui.mobile_web.MWRecommendedPageObject;
import lib.ui.mobile_web.MWReportsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReportsPageObjectFactory {

    public static ReportsPageObject get(RemoteWebDriver driver)
    {

        return new MWReportsPageObject(driver);
    }

}
