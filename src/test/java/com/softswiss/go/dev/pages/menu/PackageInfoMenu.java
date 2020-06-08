package com.softswiss.go.dev.pages.menu;

import com.softswiss.go.dev.enums.PackageInfoTab;
import framework.elements.Link;
import framework.enums.Setting;
import framework.webdriver.BaseForm;
import org.openqa.selenium.By;

public class PackageInfoMenu extends BaseForm {
    private static final String PAGE_LOCATOR = "//ul[contains(@class, 'DetailsNav')]";
    private static final String PACKAGE_LOCATOR = PAGE_LOCATOR + "//a[contains(text(), '%1$s')]";

    public PackageInfoMenu() {
        super(By.xpath(PAGE_LOCATOR), "Package info menu");
    }

    public boolean isMenuItemPresent(PackageInfoTab tab) {
        return new Link(By.xpath(String.format(PACKAGE_LOCATOR, tab.getUiText())), tab.getUiText()).waitForIsPresent(Setting.TINY_WAIT.getLongValue());
    }
}