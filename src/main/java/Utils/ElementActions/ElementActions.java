package Utils.ElementActions;

import Utils.WaitUtil.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.ClassesUtil.UtilClass.scrollToElement;

public class ElementActions {
    private ElementActions() {
    }

    //click
    public static void click(WebDriver driver, By locator) {
        WaitClass.waitForElementToBeClickable(driver, locator);
        scrollToElement(driver, locator);
        driver.findElement(locator).click();
    }

    //type
    public static void sendKeys(WebDriver driver, By locator, String value) {
        WaitClass.waitForElementToBeClickable(driver, locator);
        scrollToElement(driver, locator);
        driver.findElement(locator).sendKeys(value);
    }


    //get text
    public static String getText(WebDriver driver, By locator) {
        WaitClass.waitForElementToBeVisible(driver, locator);
        scrollToElement(driver, locator);
        return driver.findElement(locator).getText();
    }

}
