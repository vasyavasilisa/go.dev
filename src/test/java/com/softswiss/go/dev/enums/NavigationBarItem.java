package com.softswiss.go.dev.enums;

public enum NavigationBarItem {
    WHY_GO("Why Go"),
    GETTING_STARTED("Getting Started"),
    DISCOVER_PACKAGES("Discover Packages"),
    ABOUT("About");

    private String uiText;

    NavigationBarItem(String uiText) {
        this.uiText = uiText;
    }

    public String getUiText() {
        return uiText;
    }
}