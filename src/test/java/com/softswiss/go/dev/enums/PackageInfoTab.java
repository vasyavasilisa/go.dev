package com.softswiss.go.dev.enums;

public enum PackageInfoTab {
    DOC("Doc"),
    OVERVIEW("Overview"),
    SUBDIRECTORIES("Subdirectories"),
    VERSIONS("Versions"),
    IMPORTS("Imports"),
    IMPORTED_BY("Imported By"),
    LICENSES("Licenses");

    private String uiText;

    PackageInfoTab(String uiText) {
        this.uiText = uiText;
    }

    public String getUiText() {
        return uiText;
    }
}