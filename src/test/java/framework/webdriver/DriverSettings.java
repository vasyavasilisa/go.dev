package framework.webdriver;

import framework.enums.BrowserName;
import framework.enums.Setting;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class DriverSettings {

    public Map<String, Object> getBrowserOptions() {
        return Setting.OPTIONS.getMap(this.getBrowserName().toString());
    }

    public List<String> getBrowserStartArguments() {
        return Setting.START_ARGS.getList(this.getBrowserName().toString());
    }

    public Map<String, Object> getBrowserCapabilities() {
        return Setting.CAPABILITIES.getMap(this.getBrowserName().toString());
    }

    void setCapabilities(MutableCapabilities options) {
        Map<String, Object> capabilities = this.getBrowserCapabilities();
        Objects.requireNonNull(options);
        capabilities.forEach(options::setCapability);
    }

    public abstract BrowserName getBrowserName();

    public abstract Capabilities getCapabilities();
}