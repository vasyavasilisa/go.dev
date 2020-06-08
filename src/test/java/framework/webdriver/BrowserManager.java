package framework.webdriver;

import framework.enums.BrowserName;


public final class BrowserManager {

    private static final ThreadLocal<Browser> BROWSER_CONTAINER = new ThreadLocal<>();
    private static final ThreadLocal<BrowserFactory> FACTORY_CONTAINER = ThreadLocal.withInitial(BrowserFactory::new);

    private BrowserManager() {
    }

    public static Browser getBrowser() {
        if (BROWSER_CONTAINER.get() == null || BROWSER_CONTAINER.get().getDriver().getSessionId() == null) {
            setUpDefaultBrowser();
        }
        return BROWSER_CONTAINER.get();
    }

    private static void setUpDefaultBrowser() {
        BROWSER_CONTAINER.set(FACTORY_CONTAINER.get().getBrowser(BrowserName.CHROME));
    }
}