package page;

import utility.DriverUtil;

public class SauceDemo extends DriverUtil {

    private String url = "https://saucedemo.com";


    public void sauceLabs(){
        driver().get(url);
    }








}
