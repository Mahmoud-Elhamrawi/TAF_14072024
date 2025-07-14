package Driver;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {

    public static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    //set driver
    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);
    }

    //get driver
    public static WebDriver getDriver() {
        if (threadLocal.get() == null) {
            fail("Driver is null");
        }
        return threadLocal.get();
    }

    //remove driver
    public static void removeDriver() {
        threadLocal.remove();
    }

    //create instance
    public static WebDriver createInstance(String browserName) {
        WebDriver driver = DriverFactory.getBrowser(browserName);
        setDriver(driver);
        return getDriver();
    }


}
