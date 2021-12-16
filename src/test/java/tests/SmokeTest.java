package tests;

import base.UITestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class SmokeTest extends UITestBase {

    @Test
    public void isHomepageDisplayed(){
        log("Going to Homepage of the application");
        home().open();
        log("Checking to see if the Homepage is Displayed");
        boolean result = home().isPageDisplay();
        log("Results For SmokeTest");
        Assert.assertTrue(result);
    }

    @Test
    public void verifyInvalidLoginWillResultError() throws InterruptedException {
        home().open();
        home().goToLoginPage();
        boolean result1 = login().verifyPageIsDisplayed();

        log("User is verifiying invalid crendtials");
        login().enterCredential(username(),password());
        login().clickLoginButton();

        log("Verfiying that error message is Displayed");
        boolean result2 = login().verifyErrorMessage();
        logImg("Error Message");

        // Test Assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(result1);
        softAssert.assertTrue(result2);
        softAssert.assertAll();
    }





}
