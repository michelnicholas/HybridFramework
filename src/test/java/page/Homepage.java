package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.DriverUtil;

public class Homepage extends DriverUtil {

    // All available elements and Urls need for Homepage
    // All located using By indicator
    private String url = "https://trello.com";
    private By page_banner_text = By.xpath("//h1");
    private By login_button = By.xpath("//a[text() = 'Log in']");
    private By sign_up_page = By.xpath("//a[text() = 'Sign up']");


    // Method to check and see if the Homepage is displayed
    public boolean isPageDisplay(){
        driver().get(url);
        WebElement pageBanner = driver().findElement(page_banner_text);
        Boolean isPageBannerDisplayed = pageBanner.isDisplayed();
        return pageBanner.isDisplayed();
    }

    public void goToLoginPage(){
        driver().get(url);
        WebElement loginButton = driver().findElement(login_button);
        loginButton.click();
    }

    public void goToSignUpPage(){
        driver().get(url);
        WebElement signUpPage = driver().findElement(sign_up_page);
    }





}
