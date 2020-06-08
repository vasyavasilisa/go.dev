package framework.elements;

import framework.Logger;
import framework.enums.Script;
import framework.enums.Setting;
import framework.waitings.SmartWait;
import framework.webdriver.Browser;
import framework.webdriver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public abstract class BaseElement {
    private static final String LOG_CLICKING = "Clicking";
    private static final String LOG_GETTING_TEXT = "Getting text";
    private static final String LOG_ABSENT = "is absent";

    protected final Logger logger = Logger.getInstance();
    private final String name;
    private final By locator;
    private RemoteWebElement element;

    protected BaseElement(By loc, String nameOf) {
        this.locator = loc;
        this.name = nameOf;
    }

    public void waitForIsPresentAndAssert() {
        Assert.assertTrue(waitForIsPresent(Setting.AVERAGE_WAIT.getLongValue()), formatLogMsg(LOG_ABSENT));
    }

    public boolean waitForIsPresent(long timeout) {
        ExpectedCondition<Boolean> condition = ((WebDriver wd) -> {
            try {
                List<WebElement> elems = getBrowser().getDriver().findElements(locator);
                for(WebElement elem : elems) {
                    if (elem.isDisplayed()) {
                        element = (RemoteWebElement) elem;
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        });
        return SmartWait.waitForTrue(condition, timeout);
    }

    /**
     * wait the download page (on Javascript readyState)
     */
    protected void waitForPageToLoad() {
        Logger.getInstance().info("Waiting for page to load");
        ExpectedCondition<Boolean> condition = d -> {
            if (!(d instanceof JavascriptExecutor)) {
                return true;
            }
            Object result = ((JavascriptExecutor) d)
                    .executeScript(Script.RETURN_DOC_STATE.getScript());
            return result instanceof Boolean && (Boolean) result;
        };
        boolean isLoaded = SmartWait.waitForTrue(condition, Setting.PAGE_LOAD_WAIT.getLongValue());
        if (!isLoaded) {
            Logger.getInstance().warn("Page loading timed out");
        }
    }

    public RemoteWebElement getElement() {
        waitForIsPresentAndAssert();
        return element;
    }

    public By getLocator() {
        return this.locator;
    }

    protected String getName() {
        return this.name;
    }

    protected abstract String getElementType();

    public void waitAndClick() {
        this.waitForElementClickable();
        this.click();
    }

    public void clickAndWait() {
        this.click();
        this.waitForPageToLoad();
    }

    public void waitForElementClickable() {
        this.waitForElementClickable(Setting.AVERAGE_WAIT.getLongValue());
    }

    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    public void waitForElementClickable(Long timeout) {
        SmartWait.waitFor(ExpectedConditions.elementToBeClickable(this.getLocator()), timeout);
    }

    public void click() {
        logger.info(formatLogMsg(LOG_CLICKING));
        getElement().click();
    }

    public String getText() {
        logger.info(formatLogMsg(LOG_GETTING_TEXT));
        return getElement().getText();
    }

    public String getAttribute(String attr) {
        return getElement().getAttribute(attr);
    }

    private Browser getBrowser() {
        return BrowserManager.getBrowser();
    }

    protected String formatLogMsg(String message) {
        return String.format("%1$s '%2$s' %3$s %4$s", this.getElementType(), this.getName(), "::", message);
    }

    public void hover() {
        Actions actions = new Actions(getBrowser().getDriver());
        actions.moveToElement(getElement());
        actions.perform();
    }
}