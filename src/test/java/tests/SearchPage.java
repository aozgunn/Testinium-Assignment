package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchPage extends TestSetup {

    @Test
    public void SearchTest() {
        loginautomation();
        acceptCookiesPolicy(driver);
        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.xpath("//button[@data-cy='search-find-button']")).click();
        driver.findElement((By.linkText("2"))).click();
        driver.findElement(By.xpath("//*[@id='item-info-block-649247867']")).click();
        WebElement price = driver.findElement(By.id("sp-price-lowPrice"));
        String listPrice = price.getText();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("add-to-basket")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gittigidiyor.com/sepetim");


        WebElement priceBasket = driver.findElement(By.xpath(".//*[@id='cart-price-container']/div[3]/p"));
        String basketPrice = priceBasket.getText();
        Assert.assertEquals(listPrice, basketPrice);


        //Adet Arttırma
        //WebElement quantity = driver.findElement(By.id("buyitnow_adet"));
        //quantity.click();
        //quantity.sendKeys("2");

        //Sepeti Boşaltma
        //driver.findElement(By.xpath(".//*[@id='cart-item-459821224']/div[2]/div[3]/div/div[2]/div/a[1]/i")).click();



    }
}

