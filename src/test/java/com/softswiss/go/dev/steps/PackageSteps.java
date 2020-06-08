package com.softswiss.go.dev.steps;

import com.softswiss.go.dev.enums.PackageInfoTab;
import com.softswiss.go.dev.models.Package;
import com.softswiss.go.dev.pages.PackageInfoPage;
import com.softswiss.go.dev.pages.menu.PackageInfoMenu;
import framework.SoftAsserts;
import org.testng.Assert;


public class PackageSteps {
    private PackageSteps() {
    }

    public static void assertPackageInfoPageIsOpened(){
        Assert.assertTrue(new PackageInfoPage().isFormDisplayed(), "Package info wasn't opened");
    }

    public static void assertPackageMenuTabPresent(PackageInfoTab tab){
        SoftAsserts.getInstance().assertTrue(new PackageInfoMenu().isMenuItemPresent(tab),
                String.format("'%1$s' tab isn't present", tab.getUiText()));
    }

    public static void assertPackageInfo(Package expectedPack){
        Package actualPackage = new PackageInfoPage().getPackageInfo();
        SoftAsserts.getInstance().assertEquals(actualPackage.getVersion(), expectedPack.getVersion(),
                "Version isn't correct on Package info page");
        SoftAsserts.getInstance().assertEquals(actualPackage.getModule(), expectedPack.getModule(),
                "Module isn't correct on Package info page");
        SoftAsserts.getInstance().assertEquals(actualPackage.getPublishedDate(), expectedPack.getPublishedDate(),
                "Published Date isn't correct on Package info page");
    }
}
