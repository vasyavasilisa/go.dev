package framework.elements;

import org.openqa.selenium.By;

public class Link extends BaseElement {
    public Link(By locator, String name) {
        super(locator, name);
    }

    public String getElementType() {
        return "Link";
    }

    public String getHref() {
        return this.getAttribute("href");
    }
}