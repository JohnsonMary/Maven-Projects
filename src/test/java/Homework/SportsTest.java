package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SportsTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        WebElement football=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
        WebElement baseball=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        WebElement basketball=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        WebElement hockey=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        WebElement soccer=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        WebElement waterPolo=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));

        System.out.println(football.isSelected());
        System.out.println(baseball.isSelected());
        System.out.println(basketball.isSelected());
        System.out.println(hockey.isSelected());
        System.out.println(soccer.isSelected());
        System.out.println(waterPolo.isSelected());

        System.out.println("=======================");
        basketball.click();

       if(basketball.isSelected() && !football.isSelected() && !baseball.isSelected() && !hockey.isSelected() && !soccer.isSelected() && !waterPolo.isSelected() ){
           System.out.println("PASS");
       }else{
            System.out.println("FAIL");
        }






    }
}
