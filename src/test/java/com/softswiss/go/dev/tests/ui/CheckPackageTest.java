package com.softswiss.go.dev.tests.ui;

import com.softswiss.go.dev.base.BaseTest;
import com.softswiss.go.dev.enums.PackageInfoTab;
import com.softswiss.go.dev.models.Package;
import com.softswiss.go.dev.steps.HeaderSteps;
import com.softswiss.go.dev.steps.HomePageSteps;
import com.softswiss.go.dev.steps.PackageSteps;
import com.softswiss.go.dev.steps.ResultPageSteps;

public class CheckPackageTest extends BaseTest {
    private static final String SEARCH_TEXT = "setter";
    private static final String SEARCH_PACKAGE = "github.com/mikekonan/protoc-gen-setter";
    private static final String SEARCH_PACKAGE_MODULE = SEARCH_PACKAGE;


    @Override
    protected void runTest() {
        logStep(String.format("Search by '%1$s'", SEARCH_TEXT));
        HomePageSteps.assertHomePageIsOpened();
        HeaderSteps.typeAndClickSearchPackage(SEARCH_TEXT);

        logStep(String.format("Find %1$s package", SEARCH_PACKAGE));
        ResultPageSteps.assertPackageFound(SEARCH_PACKAGE);
        Package expectedPack = ResultPageSteps.getPackageInfo(SEARCH_PACKAGE);
        expectedPack.setModule(SEARCH_PACKAGE_MODULE);

        logStep("Open package info");
        ResultPageSteps.clickOnPackage(SEARCH_PACKAGE);
        PackageSteps.assertPackageInfoPageIsOpened();

        logStep("Check page tabs");
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.DOC);
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.IMPORTED_BY);
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.IMPORTS);
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.LICENSES);
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.OVERVIEW);
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.SUBDIRECTORIES);
        PackageSteps.assertPackageMenuTabPresent(PackageInfoTab.VERSIONS);

        logStep("Check package info");
        PackageSteps.assertPackageInfo(expectedPack);
    }
}