package com.cybertek.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ZeroBank {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

    }

    @Test (priority = 0)
    public void signIn() throws InterruptedException {

        WebElement inputUserName=driver.findElement(By.cssSelector("input#user_login"));
        inputUserName.sendKeys("username");
        Thread.sleep(2000);
        WebElement inputPassword=driver.findElement(By.cssSelector("input#user_password"));
        inputPassword.sendKeys("password"+Keys.ENTER);
        Thread.sleep(2000);

    }

    @Test (priority = 1)
    public void verifyUserName(){

        WebElement username=driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a"));
        String userNameOnPage=username.getText();
        System.out.println(userNameOnPage);
        Assert.assertEquals(userNameOnPage,"username");
    }

    @Test (priority = 2)
    public void verifyTitle(){

        Assert.assertEquals(driver.getTitle(),"Zero - Account Summary");

    }


    @AfterClass
    public void quit(){
        driver.quit();
    }

}
