package framework.enums;

public enum BrowserName {
    FIREFOX("firefox"),
    IE("iexplore"),
    CHROME("chrome");

    private String name;

    BrowserName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}