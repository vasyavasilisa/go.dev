package com.softswiss.go.dev.tests.ui;

import com.softswiss.go.dev.base.BaseTest;
import com.softswiss.go.dev.enums.NavigationBarItem;
import com.softswiss.go.dev.steps.HeaderSteps;
import com.softswiss.go.dev.steps.HomePageSteps;

public class CheckNavigationBarItemsPresentTest extends BaseTest {
    @Override
    protected void runTest() {
        logStep("Check Navigation Bar contains 'Why Go', 'Getting Started', 'Discovered Packages', 'About'");
        HomePageSteps.assertHomePageIsOpened();
        HeaderSteps.assertNavigationBarItemPresent(NavigationBarItem.WHY_GO);
        HeaderSteps.assertNavigationBarItemPresent(NavigationBarItem.GETTING_STARTED);
        HeaderSteps.assertNavigationBarItemPresent(NavigationBarItem.DISCOVER_PACKAGES);
        HeaderSteps.assertNavigationBarItemPresent(NavigationBarItem.ABOUT);
    }
}