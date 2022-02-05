package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;


public class GetStartedTest extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Welcome Page")})
    @DisplayName("Skip welcome page for iOS app")
    @Description("We skip welcome page only for iOS app")
    @Step("Starting test testPassThroughWelcome")
    @Severity(value = SeverityLevel.NORMAL)
    public void testPassThroughWelcome()
    {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMw())) {
            return;
        }
        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);

        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();;

        WelcomePageObject.waitForNewWayToExploreText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForAddOrEditPreferredLangText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForLearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();
    }
}
