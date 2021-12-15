package page;

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

    public void enterCredential(String username, String password) throws InterruptedException {
        driver().wait(2);
        WebElement emailInput = driver().findElement(email_input);
        emailInput.sendKeys(username);
        driver().wait(2);
        WebElement passwordInput = driver().findElement(password_input);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver().findElement(login_button);
        loginButton.click();
    }

    public boolean verifyErrorMessage(){
        WebElement errorMessage = driver().findElement(password_error);
        return errorMessage.isDisplayed();
    }


}
