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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MercuryDepartureList {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com");

    }
    @Test
    public void verifyDefaultValue(){
       WebElement inputUserName= driver.findElement(By.cssSelector("input[name='userName']"));
        inputUserName.sendKeys("tutorial");

        WebElement inputPassword=driver.findElement(By.cssSelector("input[name='password']"));
        inputPassword.sendKeys("tutorial"+ Keys.ENTER);

        WebElement box=driver.findElement(By.cssSelector("select[name='fromPort']"));
        Select firstOption=new Select(box);
        String selectedOption=firstOption.getFirstSelectedOption().getText();

        Assert.assertEquals(selectedOption,"Acapulco");
    }

    @Test
    public void verifyListOfLocations(){
        WebElement box=driver.findElement(By.cssSelector("select[name='fromPort']"));
        Select list=new Select(box);
        List <WebElement>options=list.getOptions();

        for(WebElement option:options){
            System.out.println(option.getText()+" ");

        }
    }
    @Test
    public void dropDownTesting() throws InterruptedException {
        WebElement box=driver.findElement(By.cssSelector("select[name='fromPort"));
        Select list=new Select(box);
        list.selectByValue("London");
        System.out.println("Selected Option: "+list.getFirstSelectedOption().getText());

        Thread.sleep(1000);
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
