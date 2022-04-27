package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutorizationPageObject extends MainPageObject
{
    private static final String
        LOGIN_BUTTON = "xpath://div/a[text()='Log in']",
        LOGIN_INPUT = "css:input[name='wpName']",
        PASSWORD_INPUT = "css:input[name='wpPassword']",
        SUBMIT_BUTTON = "css:button#wpLoginAttempt",
            NEXT_BUTTON ="css:button.skl-button",
        LOGIN_INPUT_DATA = "css:input.auth__input";

    public AutorizationPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("click Auth Button")
    public void clickAuthButton()
    {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button", 5);
    }

    @Step("enter Login Data login '{login}', password '{password}'")
    public void enterLoginData(String login, String password)
    {
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input",5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find and put a password to the password input",5);
    }

    @Step("submit Form")
    public void submitForm() {
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button", 5);
    }

    @Step("enter data to login form")
    public void enterPhoneData(String login)
    {
        this.waitForElementAndSendKeys(LOGIN_INPUT_DATA, login, "Cannot find and put a phone to the login input",5);
    }

    @Step("next click")
    public void nextClick() {
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find and click submit auth button", 5);
    }

    public void loginWithCode() throws InterruptedException {

        if (this.isElementPresent(LOGIN_INPUT_DATA)){
        AutorizationPageObject AutorizationPageObject = new AutorizationPageObject(driver);
        this.enterPhoneData("9000000000");
        this.nextClick();
        Thread.sleep(2000);
        this.enterPhoneData("123456");
        this.nextClick();
        Thread.sleep(5000);}
    }


}
