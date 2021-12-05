package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

    /*
    Creating Field for webdriver to be able to use Driver withing methods
     */
    private static WebDriver driver;


    /*
    Call this method to intialize the driver object
    note that calling this method will result in browser set-up
     */
    public static void open(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Call this method to terminate the driver object
    note that calling this method will result in browser termination
     */
    public static void close(){
        if (driver != null){
            driver.quit();
        }
    }


}
