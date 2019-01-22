package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Departments {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://amazon.com");
        String allOption=driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText();

        System.out.println(allOption);

        String all="All";

        if(allOption.equals(all)){
            System.out.println("PASS,default dropdown option is -> All");

        }else{
            System.out.println("FAIL");
        }

        WebElement optionPlace=driver.findElement(By.id("searchDropdownBox"));

        Select list1=new Select(optionPlace);
        List<WebElement>options= list1.getOptions();

        for(WebElement option:options){
            System.out.println(option.getText());

        }







    }
}
