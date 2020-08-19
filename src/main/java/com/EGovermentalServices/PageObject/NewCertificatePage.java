package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCertificatePage {

    private final WebDriver driver;
    private WebElement certificateTitle;
    private WebElement certificateDetails;


    public NewCertificatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNewCertificate(){

        driver.findElement(By.id("newCert")).click();
    }

    public WebElement SetTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        certificateTitle = driver.findElement(By.id("title"));
        certificateTitle.sendKeys(title);
        return certificateTitle;
    }

    public WebElement SetDetails(String details) {
        certificateDetails = driver.findElement(By.id("details"));
        certificateDetails.sendKeys(details);
        return certificateDetails;
    }

    public NewCertificatePage AddCertificate(){

        driver.findElement(By.id("btnaddcert")).click();
        return new NewCertificatePage(driver);
    }

    public void AddNewCertificate(String title, String details){
        clickOnNewCertificate();
        SetTitle(title);
        SetDetails(details);
        AddCertificate();
    }



}
