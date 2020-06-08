package com.softswiss.go.dev.steps;

import com.softswiss.go.dev.models.Package;
import com.softswiss.go.dev.pages.SearchResultsPage;
import org.testng.Assert;

public class ResultPageSteps {

    private ResultPageSteps() {
    }

    public static void assertPackageFound(String pack) {
        Assert.assertTrue(new SearchResultsPage().isPackageFoundAmongAllPages(pack));
    }

    public static Package getPackageInfo(String pack) {
        return new SearchResultsPage().getPackageInfo(pack);
    }

    public static void clickOnPackage(String pack) {
        new SearchResultsPage().clickOnPackage(pack);
    }
}