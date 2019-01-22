package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextDisappearTest2 extends TestBase {

    @Test
    public void verify1() throws InterruptedException {

        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        WebElement text = driver.findElement(By.id("myDIV"));

        Assert.assertTrue(text.isDisplayed());

        driver.findElement(By.xpath("//*[.='Toggle Hide and Show']")).click();
        Thread.sleep(1000);

        Assert.assertFalse(text.isDisplayed()) ;//text is still in html.
        //Assert.assertTrue(!text.isDisplayed());

        System.out.println(text.getText());


    }

  @Test
    public void verify2(){

        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");

        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//*[.='This is a paragraph.']"));
        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();
        Assert.assertFalse(elementDisplayed(By.xpath("body/p")));


  }
  /*
  takes a locator and returns if element matching this locator exists
  @param by
  @return
   */

  public boolean elementDisplayed(By by){

      //try to find it
      //if can't return false

      try{
          return driver.findElement(by).isDisplayed();

      }catch (NoSuchElementException e){
          return false;
      }

  }


  public boolean elementDisplayedS(By by){

      //if the locator matches the list will not be empty
      //if the locator does not match anything the list will be empty

      return driver.findElements(by).isEmpty();

  }





}

