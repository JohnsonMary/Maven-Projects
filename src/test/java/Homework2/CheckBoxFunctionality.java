package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxFunctionality {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));


        if(!firstCheckBox.isSelected()){
            System.out.println("First checkbox is not selected");
        }

        WebElement secondCheckBox=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        if(secondCheckBox.isSelected()){
            System.out.println("Second checkbox is selected");
        }

        firstCheckBox.click();
        if(firstCheckBox.isSelected()){
            System.out.println("First checkbox is  selected");
        }
        if(secondCheckBox.isSelected()){
            System.out.println("Second checkbox is selected");
        }

        secondCheckBox.click();
        if(firstCheckBox.isSelected()){
            System.out.println("First checkbox is  selected");
        }
        if(!secondCheckBox.isSelected()){
            System.out.println("Second checkbox is not selected");
        }
















    }
}
