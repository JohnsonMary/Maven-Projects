package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifySearchResultsAmazon {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @Test (priority = 0)
    public void defaultOption(){

        WebElement searchBox=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("Selenium Cookbook");
        driver.findElement(By.cssSelector("input.nav-input")).click();




    }}
