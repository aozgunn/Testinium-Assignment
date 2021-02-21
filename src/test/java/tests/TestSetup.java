package tests;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class TestSetup {
    public WebDriver driver;
    final static String BASE_URL = "https://www.gittigidiyor.com/";
    String ExpectedUrl = "https://gittigidiyor.com/";
    final static String LOGIN_URL = BASE_URL + "uye-girisi";


    void acceptCookiesPolicy(WebDriver webDriver) {
        webDriver.findElement(By.xpath("//a[@class='tyj39b-3 gQhGuc']")).click();
        webDriver.switchTo().defaultContent();

    }


    void loginautomation() {
        driver.get(LOGIN_URL);
        driver.findElement(By.id("L-UserNameField")).sendKeys("rojeso5493@geeky83.com");
        driver.findElement(By.id("L-PasswordField")).sendKeys("159357Aa");
        driver.findElement(By.id("gg-login-enter")).click();
    }


    @Before
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        //System.setProperty("webdriver.chrome.driver", "/Your driver path here");


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    @After
    public void quitDriver() {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}