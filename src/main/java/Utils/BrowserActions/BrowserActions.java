package Utils.BrowserActions;

import Driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    //open a browser
    public static void openBrowser(WebDriver driver, String Url) {
        driver.get(Url);
    }

    //close a browser
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
        DriverManager.removeDriver();
    }

    //get current url
    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    //get title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }


}
