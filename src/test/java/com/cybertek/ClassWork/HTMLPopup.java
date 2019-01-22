package com.cybertek.ClassWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HTMLPopup {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tinymce");

    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void doNotDestroyTheWorldTest(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
        driver.findElement(By.xpath("//span[.='No']")).click();

    }
    @Test
    public void oopsTest() {
        driver.get("https://sweetalert.js.org/");
        // trigger the pop up
        driver.findElement(By.xpath("(//button[@class=‘preview’])[1]")).click();

        //switch to alert
        Alert alert= driver.switchTo().alert();
        alert.accept(); //clicking on pop up

    }

    @Test
    public void dismiss(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        // trigger the pop up
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // clicking Cancel on a pop up

    }

    @Test
    public void alertText(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        // trigger the pop up
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");   // typing on the alert
        alert.accept();
    }

}








