package Pages;

import Utils.BrowserActions.BrowserActions;
import Utils.Validations.ValidationClass;
import org.openqa.selenium.WebDriver;

public class P02_LandingPage {
    private final WebDriver driver;

    public P02_LandingPage(WebDriver driver) {
        this.driver =driver;
    }












    //Validations
    public P02_LandingPage validatedUrl(String expectedUrl) {
        ValidationClass.ValidatedUrl(BrowserActions.getCurrentUrl(driver), expectedUrl, "in correct url");
        return this;
    }


    public P02_LandingPage validatedTitle(String expectedTitle) {
        ValidationClass.ValidatedTitle(BrowserActions.getTitle(driver), expectedTitle, "in correct title");
        return this;
    }
}
