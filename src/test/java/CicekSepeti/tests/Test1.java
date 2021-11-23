package CicekSepeti.tests;

import CicekSepeti.drivers.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Test1 {
    @Before
    public void setup () {
        Driver.get().get("https://www.ciceksepeti.com/");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        Driver.get().switchTo().frame(Driver.get().findElement(By.className("ab-modal-interactions")));
        Driver.get().findElement(By.className("close-icon")).click();
        Driver.get().findElement(By.className("js-subheader-close")).click();
        Driver.get().findElement(By.className("js-policy-close")).click();

    }
    @Test
    public void urunsepeteekleme () {

        Driver.get().findElement(By.cssSelector(".main-menu__item:nth-child(8)")).click();
        Driver.get().findElement(By.xpath("//img[@alt='Dizüstü Bilgisayar']")).click();
        Driver.get().findElement(By.cssSelector(".products__item:nth-child(1)")).click();
        Driver.get().findElement(By.cssSelector(".js-add-to-cart")).click();
        Assert.assertTrue(Driver.get().findElement(By.xpath("//span[text()=\"1\"]")).isDisplayed());

    }
    @Test
    public void urunsepeteekleme2 () {

        Driver.get().findElement(By.cssSelector(".main-menu__item:nth-child(6)")).click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,2000)", "");
        Driver.get().findElement(By.xpath("//img[@alt='bernardo']")).click();
        Driver.get().findElement(By.cssSelector(".products__item:nth-child(3)")).click();
        Driver.get().findElement(By.cssSelector(".js-add-to-cart")).click();
        Assert.assertTrue(Driver.get().findElement(By.xpath("//span[text()='1']")).isDisplayed());

    }
    @After
    public void teardown() {
        Driver.closeDriver();
    }
}

