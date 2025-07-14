package Utils.WaitUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitClass {

    private WaitClass() {
    }

    //wait ele to be visible
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> {
                    WebElement element = waitForElementToBeExist(driver, locator);
                    return element.isDisplayed() ? element : null;
                }
        );
    }


    //wait ele to be clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> {
                    WebElement element = waitForElementToBeExist(driver, locator);
                    return element.isEnabled() ? element : null;
                }
        );
    }

    //wait ele to be present
    public static WebElement waitForElementToBeExist(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> driver.findElement(locator)
        );
    }


}
