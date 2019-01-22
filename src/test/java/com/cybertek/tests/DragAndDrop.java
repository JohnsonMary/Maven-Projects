package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {

    @Test
    public void test(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //pass the variable in the correct order , first one is source, second one is target
        actions.dragAndDrop(source, target).perform();

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        // Write the steps for doing the drag and drop operation
        // Without using the dragAndDrop(); method

        //When we use multiple actions we need to add build() before we perform()8
        actions.clickAndHold(source).moveToElement(target).release().build().perform();





    }}
