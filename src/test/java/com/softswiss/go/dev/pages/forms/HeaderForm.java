package com.softswiss.go.dev.pages.forms;

import com.softswiss.go.dev.enums.NavigationBarItem;
import framework.elements.Button;
import framework.elements.Link;
import framework.elements.TextBox;
import framework.enums.Setting;
import framework.webdriver.BaseForm;
import org.openqa.selenium.By;

public class HeaderForm extends BaseForm {
    private static final String PAGE_LOCATOR = "//div[contains(@class, 'Header')]";
    private static final String NAVIGATION_BAR_LOCATOR = PAGE_LOCATOR + "//ul[contains(@class, 'menu')]//a[contains(text(), '%1$s')]";

    private TextBox txbSearch = new TextBox(By.xpath(PAGE_LOCATOR + "//input[contains(@title, 'Search for a package')]"),
            "Search for package");
    private Button btnSearch = new Button(By.xpath(PAGE_LOCATOR + "//button[contains(@class, 'SearchForm-submit')]"), "Search");

    public HeaderForm() {
        super(By.xpath(PAGE_LOCATOR), "Header form");
    }

    public boolean isNavigationBarItemPresent(NavigationBarItem item) {
        return new Link(By.xpath(String.format(NAVIGATION_BAR_LOCATOR, item.getUiText())),
                item.getUiText()).waitForIsPresent(Setting.MINIMAL_WAIT.getLongValue());
    }

    public void searchPackage(String searchText){
        txbSearch.waitForElementClickable();
        txbSearch.clearAndType(searchText);
        btnSearch.waitAndClick();
    }
}