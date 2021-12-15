package page;

import utility.DriverUtil;

public class SauceLabs extends DriverUtil {

    private String url = "https://saucedemo.com";


    public void sauceLabs(){
        driver().get(url);
    }








}
