package framework.webdriver;

import framework.Logger;
import framework.enums.Setting;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private final Logger logger = Logger.getInstance();
    private final RemoteWebDriver webDriver;

    public Browser(RemoteWebDriver remoteWebDriver) {
        this.webDriver = remoteWebDriver;
        this.webDriver.manage().timeouts().implicitlyWait(Setting.IMPLICIT_WAIT.getLongValue(), TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().pageLoadTimeout(Setting.PAGE_LOAD_WAIT.getLongValue(), TimeUnit.SECONDS);
    }

    public void quit() {
        Logger.getInstance().info("Closing browser");
        if (this.getDriver() != null) {
            this.getDriver().quit();
        }
    }

    public RemoteWebDriver getDriver() {
        return this.webDriver;
    }

    public void maximize() {
        Logger.getInstance().info("Maximizing browser window");
        this.getDriver().manage().window().maximize();
    }
}