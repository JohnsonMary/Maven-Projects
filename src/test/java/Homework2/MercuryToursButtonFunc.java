package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class MercuryToursButtonFunc {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://newtours.demoaut.com");
        Thread.sleep(1500);

        WebElement signOn= driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]"));
        signOn.click();

        WebElement userName=driver.findElement(By.name("userName"));
        userName.sendKeys("tutorial");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("tutorial"+ Keys.ENTER);

        WebElement roundTrip=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"));

        if(roundTrip.isSelected()){
            System.out.println("Pass|Round trip is selected");

        }else{
            System.out.println("Fail|Round trip is not selected");
        }

        WebElement oneWay=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]"));

        if(!oneWay.isSelected()){
            System.out.println("Pass|One way trip is not selected");

        }else{
            System.out.println("Fail|One way trip is  selected");
        }

        oneWay.click();
        System.out.println("One way is clicked");

        if(!roundTrip.isSelected()){
            System.out.println("Pass|Round trip is not  selected");

        }else{
            System.out.println("Fail|Round trip is selected");
        }

        if(oneWay.isSelected()){
            System.out.println("Pass|One way trip is  selected");

        }else{
            System.out.println("Fail|One way trip is not selected");
        }



















    }
}
