package com.softswiss.go.dev.pages;

import com.softswiss.go.dev.models.Package;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.Link;
import framework.enums.Setting;
import framework.webdriver.BaseForm;
import org.openqa.selenium.By;

import static com.softswiss.go.dev.functions.PackageFunctions.getPublishedFromInfo;
import static com.softswiss.go.dev.functions.PackageFunctions.getVersionFromInfo;

public class SearchResultsPage extends BaseForm {
    private static final String PACKAGE_LOCATOR = "//a[@href='/%1$s']";
    private static final String PACKAGE_INFO_LOCATOR = "//div[contains(@class, 'SearchSnippet')][.%1$s]//div[contains(@class,'infoLabel')]";

    private Button btnPaginationNext = new Button(By.xpath("//div[contains(@class,'resultCount')]//a[contains(@class,'Pagination-next')]"), "Next");

    public SearchResultsPage() {
        super(By.xpath("//div[@class='SearchResults']"), "Results page");
    }

    public boolean isPackageFoundAmongAllPages(String pack) {
        while (!isPackageFoundOnCurrentPage(pack) && btnPaginationNext.isEnabled()) {
            btnPaginationNext.click();
        }
        return isPackageFoundOnCurrentPage(pack);
    }

    public Package getPackageInfo(String pack) {
        Package packInfo = new Package();
        Label packageInfo = new Label(By.xpath(String.format(PACKAGE_INFO_LOCATOR, String.format(PACKAGE_LOCATOR, pack))), "Package info");
        String packInfoText = packageInfo.getText();
        packInfo.setVersion(getVersionFromInfo(packInfoText));
        packInfo.setPublishedDate(getPublishedFromInfo(packInfoText));
        return packInfo;
    }

    private boolean isPackageFoundOnCurrentPage(String pack) {
        return getPackageLink(pack).waitForIsPresent(Setting.TINY_WAIT.getLongValue());
    }

    private Link getPackageLink(String pack) {
        return new Link(By.xpath(String.format(PACKAGE_LOCATOR, pack)), pack);
    }

    public void clickOnPackage(String pack) {
        getPackageLink(pack).waitForElementClickable();
        getPackageLink(pack).clickAndWait();
    }
}