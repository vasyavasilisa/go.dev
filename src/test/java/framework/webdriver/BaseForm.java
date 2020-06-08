package framework.webdriver;

import framework.elements.Label;
import framework.enums.Setting;
import org.openqa.selenium.By;

public abstract class BaseForm {
    protected final By locator;
    protected final String name;

    protected BaseForm(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isFormDisplayed() {
        return new Label(this.locator, this.name).waitForIsPresent(Setting.PAGE_LOAD_WAIT.getLongValue());
    }
}