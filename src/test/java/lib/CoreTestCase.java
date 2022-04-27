package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.ui.AutorizationPageObject;
import lib.ui.WelcomePageObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

public class CoreTestCase  {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

   protected static RemoteWebDriver driver;

   @BeforeClass
   @Step("Run driver and session")
   public static void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        createAllurePropertyFile();
       // rotateScreenPortrait();
      //  skipWelcomePageForIOSApp();
        openHomeWebPageForWeb();
        AutorizationPageObject AutorizationPageObject = new AutorizationPageObject(driver);
        AutorizationPageObject.loginWithCode();
    }

    @AfterClass
    @Step("Remove driver and session")
    public static void tearDown()
    {
        driver.quit();
    }

    @Step("Rotate screen to portrait mode")
    protected void  rotateScreenPortrait()
    {
        if(driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Rotate screen to landscape mode")
    protected void rotateScreenLandscape()
    {
        if(driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }

    }

    @Step("Send mobile app to background (this method does nothing for Mobile Web)")
    protected void backgroundApp(int seconds)
    {
        if(driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
        //  driver.runAppInBackground(seconds);
        driver.runAppInBackground(Duration.ofSeconds(seconds));
        }else {
            System.out.println("Method backroudApp does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }

    }

    @Step("Open Wikipedia for Mobile Web (this method does nothing for Android and iOS)")
    protected  static void openHomeWebPageForWeb()
    {
        if(Platform.getInstance().isMw()){
            driver.get("https://test30.dev.7skills.com");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }
    }

   /* @Step("Skip welcome page screen for iOS)")
    private static void skipWelcomePageForIOSApp()
    {
        if (Platform.getInstance().isIOS()){
            AppiumDriver driver = (AppiumDriver) driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }*/

    public static void createAllurePropertyFile()
    {
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path +"/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos,"See https://docs.qameta.io/allure/#_environment");
            fos.close();
        } catch(Exception e)
        {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }

}
