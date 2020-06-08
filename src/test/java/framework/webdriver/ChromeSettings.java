package framework.webdriver;

import framework.enums.BrowserName;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChromeSettings extends DriverSettings {

    public ChromeOptions getCapabilities() {
        ChromeOptions chromeOptions = new ChromeOptions();
        this.setChromePrefs(chromeOptions);
        this.setCapabilities(chromeOptions);
        this.setChromeArgs(chromeOptions);
        return chromeOptions;
    }

    private void setChromePrefs(ChromeOptions options) {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        Map<String, Object> configOptions = this.getBrowserOptions();
        configOptions.forEach((key, value) -> {
            chromePrefs.put(key, value);
        });
        options.setExperimentalOption("prefs", chromePrefs);
    }

    private void setChromeArgs(ChromeOptions options) {
        Iterator var2 = this.getBrowserStartArguments().iterator();
        while (var2.hasNext()) {
            String arg = (String) var2.next();
            options.addArguments(new String[]{arg});
        }
    }

    public BrowserName getBrowserName() {
        return BrowserName.CHROME;
    }
}