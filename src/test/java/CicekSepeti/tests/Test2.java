package CicekSepeti.tests;

import CicekSepeti.drivers.Confreader;
import CicekSepeti.drivers.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Test2 {
    @Before
    public void setup () {
        Driver.get().get("https://www.ciceksepeti.com/");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        Driver.get().switchTo().frame(Driver.get().findElement(By.className("ab-modal-interactions")));
        Driver.get().findElement(By.className("close-icon")).click();
        Driver.get().switchTo().defaultContent();
        Driver.get().findElement(By.className("js-subheader-close")).click();
        Driver.get().findElement(By.className("js-policy-close")).click();

    }
    @Test
    public void login () throws InterruptedException {
        Driver.get().findElement(By.cssSelector(".user-menu__item:nth-child(2)")).click();
        Driver.get().findElement(By.className("users-process-list__btn")).click();
        Driver.get().findElement(By.id("EmailLogin")).sendKeys(Confreader.get("email"));
        Driver.get().findElement(By.id("Password")).sendKeys(Confreader.get("password"));
        Driver.get().findElement(By.className("js-login-button")).click();
        Thread.sleep(1000);

    }
    @Test
    public void favoriekleme () throws InterruptedException {
        login() ;
        Driver.get().findElement(By.cssSelector(".main-menu__item:nth-child(3)")).click();
        Driver.get().findElement(By.xpath("//img[@alt='çok satan çiçekler']")).click();
        Driver.get().findElement(By.cssSelector(".products__item:nth-child(4)")).click();
        Driver.get().findElement(By.cssSelector(".btn.favorite__btn")).click();
        String ProductName = Driver.get().findElement(By.className("js-ellipsize-text")).getText();
        Driver.get().findElement(By.className("user-menu__link--favorite")).click();
        String FavProductName = Driver.get().findElement(By.className("products__item-title")).getText();
        Assert.assertEquals(ProductName, FavProductName);
    }
    @Test
    public void favorilerdencikarma() throws InterruptedException {
        login();
        Driver.get().findElement(By.className("user-menu__link--favorite")).click();
        Driver.get().findElement(By.className("products__favorite-icon")).click();


    }
    @After
    public void teardown() {
        Driver.closeDriver();
    }
}