package framework.waitings;

import framework.Logger;
import framework.enums.Setting;
import framework.webdriver.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


final public class SmartWait {

    /**
     * Wait for condition and return true if waiting successful or false - otherwise.
     *
     * @param condition        Condition for waiting {@link ExpectedCondition}
     * @param timeOutInSeconds Time out in seconds for waiting
     * @return True if waiting successful or false - otherwise.
     */
    public static boolean waitForTrue(ExpectedCondition<Boolean> condition, long timeOutInSeconds) {
        try {
            return waitFor(condition, timeOutInSeconds) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for some object from condition with timeout. Wait until it's not false or null.
     *
     * @param condition        Condition for waiting {@link ExpectedCondition}
     * @param timeOutInSeconds Timeout in seconds
     * @param <T>              Object for waiting
     * @return Object from condition
     */
    public static <T> T waitFor(ExpectedCondition<T> condition, long timeOutInSeconds) {
        BrowserManager.getBrowser().getDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new WebDriverWait(BrowserManager.getBrowser().getDriver(), timeOutInSeconds);
        try {
            return wait.until(condition);
        } catch (Exception e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            BrowserManager.getBrowser().getDriver().manage().timeouts().implicitlyWait(Setting.IMPLICIT_WAIT.getLongValue(), TimeUnit.SECONDS);
        }
        return null;
    }
}
