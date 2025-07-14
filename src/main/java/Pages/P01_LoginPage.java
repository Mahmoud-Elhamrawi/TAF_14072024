package Pages;

import Utils.BrowserActions.BrowserActions;
import Utils.ElementActions.ElementActions;
import Utils.LogUtil.LogClass;
import Utils.Validations.ValidationClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //Variables
    protected WebDriver driver;


    //Constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");


    //Methods Actions
    @Step("Navigate to login page")
    public P01_LoginPage navigateToLoginPage(String url) {
        BrowserActions.openBrowser(driver, url);
        LogClass.info("Navigated to login page:", url);
        return this;
    }


    @Step("Enter username")
    public P01_LoginPage enterUsername(String username) {
        ElementActions.sendKeys(driver, this.username, username);
        LogClass.info("Entered username:", username);
        return this;
    }

    @Step("Enter password")
    public P01_LoginPage enterPassword(String password) {
        ElementActions.sendKeys(driver, this.password, password);
        LogClass.info("Entered password:", password);
        return this;
    }

    @Step("Click login button")
    public P02_LandingPage clickLoginButton() {
        ElementActions.click(driver, loginButton);
        LogClass.info("Clicked login button");
        return new P02_LandingPage(driver);
    }


    //Validations
    public P01_LoginPage validatedUrl(String expectedUrl) {
        ValidationClass.ValidatedUrl(BrowserActions.getCurrentUrl(driver), expectedUrl, "in correct url");
        return this;
    }


}
