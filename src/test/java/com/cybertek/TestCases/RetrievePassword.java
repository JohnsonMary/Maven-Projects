package com.cybertek.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RetrievePassword {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/forgot_password");

    }

    @Test
    public void clickOnPassword(){

        WebElement inputEmail=driver.findElement(By.cssSelector("input#email"));
        inputEmail.sendKeys("abc@gmail.com");
       WebElement button= driver.findElement(By.cssSelector("button#form_submit"));
       button.click();

    }
    @Test
    public void url(){

        Assert.assertEquals(driver.getCurrentUrl(),"http://the-internet.herokuapp.com/email_sent");
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }
}
