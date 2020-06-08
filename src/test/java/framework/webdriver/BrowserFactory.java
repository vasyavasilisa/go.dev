package framework.webdriver;

import framework.Logger;
import framework.enums.BrowserName;
import framework.enums.Setting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class BrowserFactory {

    public BrowserFactory() {
    }

    public Browser getBrowser(BrowserName type) {
        RemoteWebDriver driver = null;
        DriverSettings driverSettings = getDriverSettings(BrowserName.valueOf(Setting.BROWSER_NAME.getValue().toUpperCase()));
        switch (type) {
            case CHROME:
                driver = getChromeDriver(driverSettings);
                break;
            case FIREFOX:
                //todo
                break;
            default:
                throw new IllegalArgumentException("Browser name is wrong");
        }
        return new Browser(driver);
    }

    private static RemoteWebDriver getChromeDriver(DriverSettings driverSettings) {
        RemoteWebDriver driver;
        if (Setting.IS_REMOTE.getValue().equals("true")) {
            try {
                driver = new RemoteWebDriver(new URL(Setting.REMOTE_URL.getValue()), driverSettings.getCapabilities());
                driver.setFileDetector(new LocalFileDetector());
                return driver;
            } catch (MalformedURLException e) {
                String message = "Driver setting from Selenium Grid hub was failed";
                Logger.getInstance().fatal(message);
                throw new InvalidArgumentException(message + "\n" + e.getMessage());
            }
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = (ChromeOptions) driverSettings.getCapabilities();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    private DriverSettings getDriverSettings(BrowserName browserName) {
        DriverSettings driverSettings = null;
        switch (browserName) {
            case CHROME:
                driverSettings = new ChromeSettings();
                break;
            case FIREFOX:
                //todo
                break;
            default:
                throw new IllegalArgumentException(String.format("Driver settings for browser %1$s not found", browserName));
        }
        return driverSettings;
    }
}