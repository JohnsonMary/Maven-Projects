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

public class SearchAmazon {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
    }

    @Test(priority = 0)
    public void search(){

        WebElement searchBox=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("printer"+Keys.ENTER);

    }

    @Test(priority = 1)
    public void verifyTitle(){

       String title=driver.getTitle();
       if(title.contains("printer")){
           System.out.println("PASS");
        }else{
           System.out.println("FAIL");

       }
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
