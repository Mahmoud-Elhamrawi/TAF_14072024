package Utils.Validations;

import org.testng.Assert;

public class ValidationClass {
    /// hard assert
    //assert on url
    public static void ValidatedUrl(String ActualUrl, String ExpectedUrl, String message) {
        Assert.assertEquals(ActualUrl, ExpectedUrl, message);
    }

    //assert on title
    public static void ValidatedTitle(String ActualTitle, String ExpectedTitle, String message) {
        Assert.assertEquals(ActualTitle, ExpectedTitle, message);
    }

    //assert on text
    public static void ValidatedText(String ActualText, String ExpectedText, String message) {
        Assert.assertEquals(ActualText, ExpectedText, message);
    }





}
