package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRequestPage {

    private final WebDriver driver;
    private WebElement identificationID;
    private WebElement birthadd;
    private WebElement town;
    private WebElement district;
    private WebElement fullname;
    private WebElement image;

    public NewRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SetCertificate(String certificate){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Certificate")));
        Select cert= new Select(driver.findElement(By.id("Certificate")));
        cert.selectByVisibleText(certificate);
    }

    public WebElement SetIdentificationID(String ID) {
        identificationID = driver.findElement(By.id("txtID"));
        identificationID.sendKeys(ID);
        return identificationID;
    }

    public WebElement SetBirthAddress(String birthAdd) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtBirthAddress")));
        birthadd = driver.findElement(By.id("txtBirthAddress"));
        birthadd.sendKeys(birthAdd);
        return birthadd;
    }

    public WebElement SetTown(String Town) {
        town = driver.findElement(By.id("txtTown"));
        town.sendKeys(Town);
        return town;
    }

    public WebElement SetDistrict(String District) {
        district = driver.findElement(By.id("txtDistrict"));
        district.sendKeys(District);
        return district;
    }


    public void Check(){

        driver.findElement(By.id("btnCheck")).click();
    }

    public WebElement SetFullName(String FN) {
        fullname = driver.findElement(By.id("txtFname"));
        fullname.sendKeys(FN);
        return fullname;
    }

    public WebElement SetImage(String url){
        image = driver.findElement(By.id("file1"));
        image.sendKeys(url);
        return image;
    }

    public ServicesPage Apply(){

        driver.findElement(By.id("btnApply")).click();
        return new ServicesPage(driver);
    }

    public void CheckID(String Certificate, String ID, String BirthAdd, String Town, String District,String file){

        SetCertificate(Certificate);
        SetIdentificationID(ID);
        Check();
        SetBirthAddress(BirthAdd);
        SetTown(Town);
        SetDistrict(District);
        SetImage(file);

    }


}
