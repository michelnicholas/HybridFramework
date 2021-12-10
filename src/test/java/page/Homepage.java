package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.DriverUtil;

public class Homepage extends DriverUtil {

    private String url = "https://trello.com";
    private By page_banner_text = By.xpath("//h1");


    public boolean isPageDisplay(){
        driver().get(url);
        WebElement pageBanner = driver().findElement(page_banner_text);
        Boolean isPageBannerDisplayed = pageBanner.isDisplayed();
        return pageBanner.isDisplayed();

    }





}
