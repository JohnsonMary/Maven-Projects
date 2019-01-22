package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import com.sun.tools.javac.tree.DCTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase
{

   @Test
    public void  test() throws InterruptedException {
       driver.get("http://the-internet.herokuapp.com/upload");
       WebElement chooseFile = driver.findElement(By.id("file-upload"));

       String path = "/Users/maryjohnson/Downloads/test.txt";

       chooseFile.sendKeys(path);

       driver.findElement(By.id("file-submit")).click();

       Thread.sleep(2000);

       Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());






   }

}
