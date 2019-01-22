package com.cybertek.tests;
/*
open chrome
go to google
search for selenium cookbook
verify title contains the seacrh term
 */

import com.cybertek.utilities.TestBase;
import com.google.common.collect.Multimaps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleDemo extends TestBase {



    @Test
    public void titleTest(){
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("selenium cookbook"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));

    }






}
