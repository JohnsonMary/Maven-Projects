package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyTextDisappearTest  extends TestBase {



    @Test
    public void verify1() throws InterruptedException {

        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        WebElement text = driver.findElement(By.id("myDIV"));

        Assert.assertTrue(text.isDisplayed());

        driver.findElement(By.xpath("//*[.='Toggle Hide and Show']")).click();
        Thread.sleep(1000);

        Assert.assertFalse(text.isDisplayed()) ;
      //Assert.assertTrue(!text.isDisplayed());

        System.out.println(text.getText());


    }






}
