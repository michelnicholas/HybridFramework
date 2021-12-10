package page;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.DriverUtil;

public class LoginPage extends DriverUtil {
    private By page_banner = By.xpath("//h1[text() = 'Log in to Trello]");
    private By email_input = By.id("user");
    private By password_input = By.id("password");
    private By login_button = By.id("login");
    private By password_error = By.xpath("(//p[@class = 'error-message'])[1]");


    public boolean verifyPageIsDisplayed(){
        WebElement isDisplay = driver().findElement(page_banner);
        Boolean areWeOnLoginPage = isDisplay.isDisplayed();
        return isDisplay.isDisplayed();

    }

}
