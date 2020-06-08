package framework.enums;


import framework.functions.JsonParser;

import java.util.List;
import java.util.Map;

public enum Setting {
    BROWSER_NAME("/browserName"),
    REMOTE_URL("/remoteConnectionUrl"),
    OPTIONS("/options"),
    START_ARGS("/startArguments"),
    CAPABILITIES("/capabilities"),
    IS_REMOTE("/isRemote"),
    MINIMAL_WAIT("/timeouts/timeoutMinimal"),
    POLLING_INTERVAL("/timeouts/timeoutPollingInterval"),
    DEFAULT_WAIT("/timeouts/timeoutDefault"),
    AVERAGE_WAIT("/timeouts/timeoutAverage"),
    POLLING_INTERVAL_INCREASED("/timeout/timeoutPollingIntervalIncreased"),
    IMPLICIT_WAIT("/timeouts/timeoutImplicit"),
    TINY_WAIT("/timeouts/timeoutTiny"),
    PAGE_LOAD_WAIT("/timeouts/timeoutPageLoad"),
    EMAIL_WAIT("/timeouts/timeoutEmailWait");

    private String value;
    private JsonParser jsonFile;

    Setting(String value) {
        this.value = value;
        this.jsonFile = new JsonParser("settings.json");
    }

    public String getValue() {
        return jsonFile.getValue(value).toString();
    }

    public Long getLongValue() {
        return Long.parseLong(getValue());
    }

    public Map<String, Object> getMap(String browserName) {
       return jsonFile.getMap(getDriverSettingsKey(browserName));
    }

    public List<String> getList(String browserName) {
        return jsonFile.getList(getDriverSettingsKey(browserName));
    }

    private String getDriverSettingsKey(String browserName){
       return "/driverSettings/" + browserName + value;
    }
}