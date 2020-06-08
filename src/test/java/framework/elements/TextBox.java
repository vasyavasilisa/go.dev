package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public class TextBox extends BaseElement {

    public TextBox(By locator, String name) {
        super(locator, name);
    }


    protected String getElementType() {
        return "TextBox";
    }

    public String getValue() {
        return getAttribute("value");
    }

    public void clearAndType(final String value) {
        logger.info(formatLogMsg(String.format("Typing '%1$s'", value)));
        RemoteWebElement webElement = getElement();
        webElement.clear();
        webElement.sendKeys(value);
    }
}