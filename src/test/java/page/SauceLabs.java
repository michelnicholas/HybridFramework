package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.DriverUtil;

public class SauceLabs extends DriverUtil {

    private String url = "https://saucedemo.com";
    public By sauce_demo_header = By.xpath("//div[@id = 'root']//div[@class='login_logo']");


    public void sauceLabs(){
        driver().get(url);
    }


    public Boolean isHomepageVisible(){
        driver().get(url);
        WebElement sauceDemoHeader = driver().findElement(sauce_demo_header);
        return sauceDemoHeader.isDisplayed();

    }








}
