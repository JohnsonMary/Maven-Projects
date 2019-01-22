package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MercuryToursDepartureList {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://newtours.demoaut.com");

        WebElement userName=driver.findElement(By.name("userName"));
        userName.sendKeys("tutorial");
        Thread.sleep(1000);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("tutorial"+ Keys.ENTER);

        Select dropBox=new Select(driver.findElement(By.name("fromPort")));

        String ap="Acapulco";

        if(dropBox.getFirstSelectedOption().getText().equals(ap)){
            System.out.println("PASS| Default is Acapulco");

        }else{
            System.out.println("FAIL|Default is not Acapulco ");
        }

        List<WebElement> options=dropBox.getOptions();

        for(WebElement option:options){

            System.out.println(option.getText());
        }

        System.out.println("Selecting New York");
        dropBox.selectByIndex(3);
        System.out.println("Selected Option: "+ dropBox.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        System.out.println("Selecting Paris");
        dropBox.selectByIndex(4);
        System.out.println("Selected Option: "+dropBox.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        System.out.println("Selecting London");
        dropBox.selectByValue("London");
        System.out.println("Selected Option: "+dropBox.getFirstSelectedOption().getText());




















    }
}