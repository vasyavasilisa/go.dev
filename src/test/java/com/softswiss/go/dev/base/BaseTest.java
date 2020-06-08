package com.softswiss.go.dev.base;

import framework.Logger;
import framework.SoftAsserts;
import framework.StepLogger;
import framework.webdriver.BrowserManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class BaseTest {
    protected abstract void runTest();

    @Test
    protected void xTest() {
        try {
            runTest();
        } finally {
            SoftAsserts.getInstance().assertAll();
        }
    }

    @BeforeMethod
    public void before() {
        StepLogger.getInstance().resetStepCounter();
        Logger.getInstance().setUpLogFile(getClass().getSimpleName());
        BrowserManager.getBrowser().getDriver().navigate().to("https://go.dev/");
        BrowserManager.getBrowser().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserManager.getBrowser().quit();
        SoftAsserts.refreshSoftAssert();
    }

    protected void logStep(String message) {
        StepLogger.getInstance().logStep(message);
    }
}
