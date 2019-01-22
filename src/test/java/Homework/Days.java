package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Days {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        WebElement friday=driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input"));

        friday.click();
        String fridayText=driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input")).getText();
        System.out.println(fridayText);
        friday.click();
        System.out.println(fridayText);
        friday.click();
        System.out.println(fridayText);

        WebElement homePage=driver.findElement(By.partialLinkText("Homepage"));
        homePage.click();











    }
}
