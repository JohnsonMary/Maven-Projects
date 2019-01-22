package com.cybertek.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
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

public class Departments {

    WebDriver driver;
    Select list;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

    }

    @Test
    public void defaultDropdown(){

        WebElement dropDown=driver.findElement(By.cssSelector("#searchDropdownBox"));
        list=new Select(dropDown);
        Assert.assertEquals(list.getFirstSelectedOption().getText(),"All Departments");

    }

    @Test
    public void sortedAlphabetically() {

        for (int i = 1; i < list.getOptions().size() - 1; i++) {

            String first = list.getOptions().get(i).getText();
            String next = list.getOptions().get(i + 1).getText();

            Assert.assertTrue(first.compareTo(next) <= 0);
            System.out.println("Comparing " + first + " with " + next);

        }
    }

    @Test
    public void departmentNames(){
        WebElement icon=driver.findElement(By.cssSelector("i.hm-icon.nav-sprite"));
        icon.click();
        WebElement button= (driver.findElement(By.partialLinkText("Full Store")));
        button.click();

        List<WebElement> mainDept=driver.findElements(By.cssSelector("h2.fsdDeptTitle"));

        for(WebElement option:mainDept){
            System.out.println(option.getText());


        }

    }

    @AfterClass
    public void quit(){
        driver.quit();
    }



}
