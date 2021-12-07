package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import utility.DriverUtil;

public class UITestBase {

    // create variable for loginPage
    private LoginPage login;

    @BeforeMethod
    public void setUp(){
        DriverUtil.open();
    }

    @AfterMethod
    public void cleanUp(){
        DriverUtil.close();
    }







}
