package tests;

import base.UITestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void verifyInvalidLoginWillResultError(){
        home().open();
        home().goToLoginPage();
        boolean result1 = login().verifyPageIsDisplayed();


    }


}