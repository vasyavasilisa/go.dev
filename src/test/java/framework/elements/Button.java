package framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {
    public Button(By locator, String name) {
        super(locator, name);
    }

    protected String getElementType() {
        return "Button";
    }
}