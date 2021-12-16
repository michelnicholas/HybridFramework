package base;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import page.Homepage;

import page.LoginPage;
import page.SauceDemo;
import utility.DriverUtil;
import utility.TestListener;

public class UITestBase {

    // create variable for LoginPage and Homepage
    private Homepage home;
    private LoginPage login;
    private SauceDemo sauceLabs;

    /* Before Method implemented from TestNG to call browser to open
    before all methods
    */
    @BeforeMethod
    public void setUp(){
        DriverUtil.open();
    }

    /* After method implemented from TestNG to call browser to close
    after all methods
     */

    @AfterMethod
    public void cleanUp(){
        DriverUtil.close();
    }


    @Test
    public void helloWorld(){
        System.out.println("Hello world");
    }

    /*
    The protected access modifier is accessible within the package. However, it can also
     accessible outside the package but through inheritance only.
     We can't assign protected to outer class and interface.
     */
    protected Homepage home(){
        if (home == null){
            home = new Homepage();
            return home;
        }
        return home;
    }

    public LoginPage login(){
        if(login == null){
            login = new LoginPage();
            return login;
        }
        return login;
    }

    public SauceDemo sauceLabs(){
        if (sauceLabs == null){
            sauceLabs = new SauceDemo();
            return sauceLabs;
        }
        return sauceLabs;
    }

    public void log(String message){
        TestListener.step().info(message);
    }

    public String username(){
        return new Faker().name().username();
    }

    public String password(){
        return new Faker().internet().password();
    }

    public void logImg(String message){
        WebDriver driver = DriverUtil.driver();
        String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        TestListener.step().addScreenCaptureFromBase64String(screenshot,message);
    }










}
