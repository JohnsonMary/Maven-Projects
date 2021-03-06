package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestaShopHomepage {

    public PrestaShopHomepage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (linkText = "Sign in")
    public static WebElement signIn;

    public static WebElement product(String productName){

        String xpath = "(//h5/a[@title = '"+productName+"'])[1]";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }

    @FindBy(xpath = "asaddfdgsdg")
    public WebElement adress;

    @FindBy(xpath = "asaddfdgsdg")
    public WebElement agent;


    @FindBy(xpath = "asaddfdgsdg")
    public WebElement map;



}
