package lib.ui.mobile_web;

import lib.ui.ReportsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWReportsPageObject extends ReportsPageObject {

    static {

        REPORTS = "xpath://a[@href='/recommended']";
    }

    public MWReportsPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }
}
