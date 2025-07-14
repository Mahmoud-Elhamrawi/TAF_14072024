package Utils.ClassesUtil;

import Driver.DriverManager;
import Utils.AllureUil.AllureClass;
import Utils.LogUtil.LogClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilClass {
    //take screenshot

    public static final String screenshotPath = "test-outputs/screenshots/";

    public static void takeScreenshot(String screenshotName) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File Dist = new File(screenshotPath + screenshotName + getTimeStamp() + ".png");
            FileUtils.copyFile(src, Dist);
            AllureClass.addScreenshotToAllureReport(screenshotName, Dist.getPath());
            LogClass.info("Screenshot taken");
        } catch (Exception e) {
            LogClass.error("fail to take screenshot", e.getMessage());
        }

    }

    // get time stamp
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    }

    // scroll to element
    public static void scrollToElement(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"
                , driver.findElement(locator));

    }

}
