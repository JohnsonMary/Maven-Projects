package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingPage {

    public ListingPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


}
