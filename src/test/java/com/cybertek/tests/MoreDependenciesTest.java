package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoreDependenciesTest {

    @Test
    public void openBrowser(){
        System.out.println("Opening Browser");
    }

    @Test (dependsOnMethods = "openBrowser",priority = 0)
    public void login(){
        System.out.println("Login");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "login")
    public void logOut(){
        System.out.println("Logout");
    }
}
