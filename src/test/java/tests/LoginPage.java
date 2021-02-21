package tests;

import org.junit.Assert;
import org.junit.Test;

public class LoginPage extends TestSetup {

    @Test
    public void loginTest(){
        loginautomation();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(BASE_URL, actualUrl);
    }
}
