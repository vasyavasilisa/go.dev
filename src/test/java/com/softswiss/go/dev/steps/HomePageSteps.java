package com.softswiss.go.dev.steps;

import com.softswiss.go.dev.pages.HomePage;
import org.testng.Assert;

public class HomePageSteps {

    private HomePageSteps() {
    }

    public static void assertHomePageIsOpened(){
        Assert.assertTrue(new HomePage().isFormDisplayed(), "Home page wasn't opened");
    }
}