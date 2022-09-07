package lib.ui.factories;

import lib.Platform;
import lib.ui.SettingsPageObject;
import lib.ui.android.AndroidSettingsPageObject;
import lib.ui.ios.iOSSettingsPageObject;
import lib.ui.mobile_web.MWSettingsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SettingsPageObjectFactory {
    public static SettingsPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidSettingsPageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new iOSSettingsPageObject(driver);
        } else {
            return new MWSettingsPageObject(driver);
        }
    }
}
