package com.softswiss.go.dev.pages;

import framework.webdriver.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    public HomePage() {
        super(By.xpath("//div[contains(@class, 'Hero-actions')]//a[contains(@href, 'learn')]"), "Home page");
    }
}
