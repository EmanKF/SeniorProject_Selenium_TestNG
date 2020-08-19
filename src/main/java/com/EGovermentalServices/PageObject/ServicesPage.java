package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicesPage {

    private final WebDriver driver;

    public ServicesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewRequestPage MakeNewRequest()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNewRequest")));
        driver.findElement(By.id("btnNewRequest")).click();
        return new NewRequestPage(driver);
    }

    public NewCitizenPage InsertNewCitizen() {
        driver.findElement(By.id("hrefNewCit")).click();
        return new NewCitizenPage(driver);
    }

    public UpdateSkillsPage UpdateSkill() {
        driver.findElement(By.id("hrefUpdateSkill")).click();
        return new UpdateSkillsPage(driver);
    }

    public NewCertificatePage InsertUpdateCertificate() {
        driver.findElement(By.id("hrefInsUpdCert")).click();
        return new NewCertificatePage(driver);
    }

}
