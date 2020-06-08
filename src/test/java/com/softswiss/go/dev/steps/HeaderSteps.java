package com.softswiss.go.dev.steps;

import com.softswiss.go.dev.enums.NavigationBarItem;
import com.softswiss.go.dev.pages.forms.HeaderForm;
import framework.SoftAsserts;

public class HeaderSteps {

    private HeaderSteps() {
    }

    public static void assertNavigationBarItemPresent(NavigationBarItem navigationBarItem) {
        SoftAsserts.getInstance().assertTrue(new HeaderForm().isNavigationBarItemPresent(navigationBarItem),
                String.format("'%1$s' header item isn't present", navigationBarItem.getUiText()));
    }

    public static void typeAndClickSearchPackage(String searchText) {
        new HeaderForm().searchPackage(searchText);
    }
}