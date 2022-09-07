package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ReportsPageObject extends MainPageObject{
        protected static  String
                REPORTS;


        public ReportsPageObject(RemoteWebDriver driver)
        {
            super(driver);
        }
}
