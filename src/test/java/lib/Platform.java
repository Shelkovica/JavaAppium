package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String APPIUM_URL = "http://127.0.0.1:4728/wd/hub";
    private static final String URL_DEV = "https://test30.dev.7skills.com/";
    private static final String URL_STAGE = "https://test3.stage.7skills.com/";
    private static final String URL_PROD = "http://127.0.0.1:4728/wd/hub";
    private static final String SERVER_DEV = "dev";
    private static final String SERVER_STAGE = "stage";
    private static final String SERVER_PROD = "prod";

    private static Platform instance;

    private Platform(){}

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if(this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndriodDesiredCapabilities());
        } else if (this.isIOS()){
            return  new IOSDriver(URL, this.getiOSDesiredCapabilities());
        } else if (this.isMw()){
            return new ChromeDriver(this.getMwChromeOptions());
        }        else {
            throw new Exception("Cannot detect type of the Driver. Platform value: "+ this.getPlatformVar());
    }
    }



    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }

    public boolean isMw()
    {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }


    public boolean isDev()
    {
        return isServer(SERVER_DEV);
    }

    public boolean isStage()
    {
        return isServer(SERVER_STAGE);
    }

    public boolean isProd()
    {
        return isServer(SERVER_PROD);
    }


    private DesiredCapabilities getAndriodDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","com.edu.client");
        //capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("appActivity",".com.isidroid.b21.clean.presentation.splash.SplashActivity");
        capabilities.setCapability("app","D:/job/JavaAppiumTest/apk/com.edu.client.apk");

        return capabilities;
    }

    private DesiredCapabilities getiOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 11");
        capabilities.setCapability("platformVersion", "15.2");
        //capabilities.setCapability("app","C:/vica/job/Новая папка/training_mobile_auto/apks/org.wikipedia.apk");
        capabilities.setCapability("app", "/Users/andreigeiko/Documents/GitHub/training_mobile_auto/apks/Wikipedia.app");
        return capabilities;
    }

    private ChromeOptions getMwChromeOptions()
    {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 1280);
        deviceMetrics.put("height", 1024);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation  = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1280,1024");

        return chromeOptions;
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

    public String getServerVar()
    {
        return System.getenv("SERVER");
    }

    private boolean isServer(String my_server)
    {
        String server = this.getServerVar();
        return my_server.equals(server);
    }
}
