package com.cybertek.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasicAuthenticationAdressBook {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test(priority = 0)
    public void signInButton() throws InterruptedException {
        WebElement email=driver.findElement(By.cssSelector("input#session_email"));
        email.click();

        email.sendKeys("kexesobepu@zsero.com");
        Thread.sleep(1000);
        WebElement password=driver.findElement(By.cssSelector("input#session_password"));
        password.sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Test (priority = 1)
    public void verifyUserName(){
      String userName=  driver.findElement(By.cssSelector("span.navbar-text")).getText();

        Assert.assertEquals(userName,"kexesobepu@zsero.com");
    }

    @Test (priority = 2)
    public void verifyTitle(){
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,"Address Book");
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
