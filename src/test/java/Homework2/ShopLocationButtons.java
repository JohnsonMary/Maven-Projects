package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShopLocationButtons {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://etsy.com");
        WebElement searchBox=driver.findElement(By.id("search-query"));
        searchBox.sendKeys("bracelet"+ Keys.ENTER);

        Thread.sleep(1000);

       // WebElement anywhereOption=driver.findElement(By.xpath("//*[@id=\"search-filter-reset-form\"]/div[14]/fieldset/div/div/div[1]/label[1]/input"));
        WebElement anywhereOption=driver.findElement(By.xpath("//input[@aria-label='Anywhere']"));
        if(anywhereOption.isSelected()){
            System.out.println("PASS|Anywhere option is selected");
        }else{
            System.out.println("FAIL|Anywhere option is not selected");

        }

        WebElement USOption=driver.findElement(By.xpath("//input[@aria-label='United States']"));

        if(!USOption.isSelected()){
            System.out.println("PASS|US option is not selected");
        }else{
            System.out.println("FAIL|US option is  selected");

        }

        USOption.click();

        if(!anywhereOption.isSelected()){
            System.out.println("PASS|Anywhere option is not selected");
        }else{
            System.out.println("FAIL|Anywhere option is selected");

        }
        if(USOption.isSelected()){
            System.out.println("PASS|US option is selected");
        }else{
            System.out.println("FAIL|US option is not  selected");

        }









    }
}
