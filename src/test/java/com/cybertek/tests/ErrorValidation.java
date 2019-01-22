package com.cybertek.tests;

import com.cybertek.Pages.HomePage;
import com.cybertek.Pages.ListingPage;
import com.cybertek.Pages.PrestaShopHomepage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.Bidi;

public class ErrorValidation extends TestBase {
HomePage homePage = new HomePage();
/*
Wrong email
1. go to website http://automationpractice.com/index.php
2. try to login with wrong email
3. verify error message Invalid email address.
 */

   @Test
   public void wrongUserNameTest() throws InterruptedException {

      HomePage homePage = new HomePage();


      driver.get(ConfigurationReader.getProperty("url"));

      String password = ConfigurationReader.getProperty("password");
      homePage.login("",password);
      homePage.loginButton.click();

      String error = "Invalid Login or Password.";
      String actualError=homePage.errorMessage.getText();

      Assert.assertEquals(actualError,error);

   }

   @Test
   public void wrongPasswordtest() throws InterruptedException {


      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

      homePage.username.sendKeys("Tester");
      homePage.password.sendKeys("admin");
      homePage.loginButton.click();

      String error = "Invalid Login or Password.";
      String actualError = homePage.errorMessage.getText();

      Assert.assertEquals(actualError,error);


   }
/*
No username
1. go to website http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. try to login no username
3. verify error message Invalid Login or Password.
 */
   @Test
   public void noUsernameTest(){

      homePage.open();
      homePage.login("","tester");
      homePage.password.sendKeys("test");
      homePage.loginButton.click();

      String error = "Invalid Login or Password.";
      String actualError=homePage.errorMessage.getText();
      Assert.assertEquals(actualError,error);

   }

   /*
   No password
1. go to website http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. try to login with no password

3. verify error message Invalid Login or Password.

    */

   @Test
   public void noPasswordTest(){

      homePage.open();
      homePage.login("Tester","");

      homePage.username.sendKeys("Tester");
      homePage.loginButton.click();

      String error = "Invalid Login or Password.";
      String actualError=homePage.errorMessage.getText();

      Assert.assertEquals(actualError,error);

   }

   //this is just a method does not do anything
   @Test
   public void test(){

      ListingPage nilesLane = new ListingPage();
      ListingPage palmetLane = new ListingPage();

      WebElement tshirt = PrestaShopHomepage.product("Blouse");
      WebElement dress = PrestaShopHomepage.product("Printed Chiffon Dress");


   }

}
