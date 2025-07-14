package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.Objects;

import static Utils.DataUtil.ReadPropertyFile.getPropertyKey;

public class DriverFactory {

    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-default-apps");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-infobars");
                if (!getPropertyKey("executionType").equals("local")) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                Map<String, Object> chromePrefs = Map.of(
                        "profile.default_content_settings.notifications", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "password_manager_enabled", false);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                return new ChromeDriver(chromeOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.addArguments("--disable-default-apps");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

//                Map<String, Object> edgePrefs = Map.of(
//                        "profile.default_content_settings.notifications", 2,
//                        "credentials_enable_service", false,
//                        "profile.password_manager_enabled", false,
//                        "password_manager_enabled", false);
//                edgeOptions.setExperimentalOption("prefsEdge", edgePrefs);
                return new EdgeDriver(edgeOptions);
            case "firefox":
                return new FirefoxDriver();
            default:
                return null;
        }

    }
}
