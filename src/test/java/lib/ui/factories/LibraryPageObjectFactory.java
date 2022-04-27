package lib.ui.factories;

import lib.Platform;
import lib.ui.LibraryPageObject;
import lib.ui.android.AndroidLibraryPageObject;
import lib.ui.ios.iOSLibraryPageObject;
import lib.ui.mobile_web.MWLibraryPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LibraryPageObjectFactory {

    public static LibraryPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidLibraryPageObject(driver);
        } else if(Platform.getInstance().isIOS()){
            return new iOSLibraryPageObject(driver);
        } else {return new MWLibraryPageObject(driver);}
    }
}
