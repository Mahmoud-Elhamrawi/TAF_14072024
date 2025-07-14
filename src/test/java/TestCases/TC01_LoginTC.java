package TestCases;


import Driver.DriverManager;
import Listener.TestNgListener;
import Pages.P01_LoginPage;
import Utils.BrowserActions.BrowserActions;
import Utils.DataUtil.ReadJsonFile;
import Utils.LogUtil.LogClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Utils.DataUtil.ReadJsonFile.getJsonKey;
import static Utils.DataUtil.ReadPropertyFile.getPropertyKey;

@Listeners(TestNgListener.class)
public class TC01_LoginTC {

    //Variables
    WebDriver driver;
    ReadJsonFile readJsonFile;

    @Test
    public void loginTC() {

        new P01_LoginPage(driver)
                .validatedUrl(getPropertyKey("loginPageURL"))
                .enterUsername(getJsonKey("valid-credential-data.username"))
                .enterPassword(getJsonKey("valid-credential-data.password"))
                .clickLoginButton();

        LogClass.info("User logged in successfully");
    }

    //Configuration
    @BeforeClass
    public void setUpClass() {
        readJsonFile = new ReadJsonFile("loginData");
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUpMethod(@Optional("firefox") String browser) {
      //  String BrowserName = System.getProperty("browser")  != null ?
        //        System.getProperty("browser"):getPropertyKey("browserName");


        driver = DriverManager.createInstance(browser);
        LogClass.info("Browser is opened :", browser);

        new P01_LoginPage(driver)
                .navigateToLoginPage(getPropertyKey("loginPageURL"));
        LogClass.info("Navigated to login page:", getPropertyKey("loginPageURL"));

    }

    @AfterMethod
    public void tearDownMethod() {
        BrowserActions.closeBrowser(driver);
    }

}
