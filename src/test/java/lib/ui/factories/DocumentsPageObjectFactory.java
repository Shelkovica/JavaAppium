package lib.ui.factories;

import lib.Platform;
import lib.ui.DocumentsPageObject;
import lib.ui.android.AndroidDocumentsPageObject;
import lib.ui.ios.iOSDocumentsPageObject;
import lib.ui.ios.iOSLibraryPageObject;
import lib.ui.mobile_web.MWDocumentsPageObject;
import lib.ui.mobile_web.MWLibraryPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DocumentsPageObjectFactory {

    public static DocumentsPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidDocumentsPageObject(driver);
        } else if(Platform.getInstance().isIOS()){
            return new iOSDocumentsPageObject(driver);
        } else {return new MWDocumentsPageObject(driver);}
    }
}
