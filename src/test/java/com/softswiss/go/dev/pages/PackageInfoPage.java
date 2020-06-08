package com.softswiss.go.dev.pages;

import com.softswiss.go.dev.models.Package;
import framework.elements.Label;
import framework.webdriver.BaseForm;
import org.openqa.selenium.By;

import static com.softswiss.go.dev.functions.PackageFunctions.*;

public class PackageInfoPage extends BaseForm {
    private Label lblVersion = new Label(By.xpath("//div[contains(@class, 'version')]"), "Version");
    private Label lblPackageInfo = new Label(By.xpath("//div[contains(@class,'infoLabel')]"), "Package info");

    public PackageInfoPage() {
        super(By.xpath("//div[contains(@class, 'DetailsHeader-infoLabel')]"), "Package info page");
    }

    public Package getPackageInfo() {
        Package pack = new Package();
        pack.setVersion(lblVersion.getText());
        pack.setPublishedDate(getPublishedFromInfo(lblPackageInfo.getText()));
        pack.setModule(getModuleFromInfo(lblPackageInfo.getText()));
        return pack;
    }
}