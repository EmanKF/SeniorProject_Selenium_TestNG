package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCitizenPage {

    private final WebDriver driver;
    private WebElement identificationID;
    private WebElement fullname;
    private WebElement nationality;
    private WebElement DOB;
    private WebElement homeAdd;
    private WebElement town;
    private WebElement district;
    private WebElement job;
    private WebElement birthAdd;
    private WebElement recordId;
    private WebElement father;
    private WebElement mother;

    public NewCitizenPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement SetIdentificationID(String ID) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtID")));
        identificationID = driver.findElement(By.id("txtID"));
        identificationID.sendKeys(ID);
        return identificationID;
    }

    public WebElement SetFullName(String FN) {
        fullname = driver.findElement(By.id("txtFname"));
        fullname.sendKeys(FN);
        return fullname;
    }

    public WebElement SetNationality(String nat) {
        nationality = driver.findElement(By.id("nationalitysel"));
        nationality.sendKeys(nat);
        return nationality;
    }

    public WebElement SetDOB(String dob) {
        DOB = driver.findElement(By.id("txtDOB"));
        DOB.sendKeys(dob);
        return DOB;
    }

    public WebElement SetHomeAddress(String home) {
        homeAdd = driver.findElement(By.id("txtHomeAddress"));
        homeAdd.sendKeys(home);
        return homeAdd;
    }

    public WebElement SetTown(String Town) {
        town = driver.findElement(By.id("txtTown"));
        town.sendKeys(Town);
        return town;
    }

    public WebElement SetDistrict(String dist) {
        district = driver.findElement(By.id("txtDistrict"));
        district.sendKeys(dist);
        return district;
    }

    public WebElement SetJob(String Job) {
        job = driver.findElement(By.id("txtjob"));
        job.sendKeys(Job);
        return job;
    }

    public WebElement SetBirthAddress(String BirthAdd) {
        birthAdd = driver.findElement(By.id("txtBirthAddress"));
        birthAdd.sendKeys(BirthAdd);
        return birthAdd;
    }

    public WebElement SetRecordID(String RID) {
        recordId = driver.findElement(By.id("txtRecordID"));
        recordId.sendKeys(RID);
        return recordId;
    }

    public WebElement SetFather(String ID) {
        father = driver.findElement(By.id("txtFatherName"));
        father.sendKeys(ID);
        return father;
    }
    public WebElement SetMother(String ID) {
        mother = driver.findElement(By.id("txtMotherName"));
        mother.sendKeys(ID);
        return mother;
    }

    public void SetReligion(String rel){
        Select cert= new Select(driver.findElement(By.id("religion")));
        cert.selectByVisibleText(rel);
    }

    public void SetGender(String gend){
        Select cert= new Select(driver.findElement(By.id("gender")));
        cert.selectByVisibleText(gend);
    }

    public void SetMaritalStatus(String MS){
        Select cert= new Select(driver.findElement(By.id("maritalStatus")));
        cert.selectByVisibleText(MS);
    }

    public ServicesPage Apply(){
        driver.findElement(By.id("btnApply")).click();
        return new ServicesPage(driver);
    }

    public void ApplyAddingCitizen(String ID, String FN, String Nat, String DOB, String home, String town, String district, String job, String birthAdd, String recordID, String father, String mother, String rel, String gender, String MS){
       SetIdentificationID(ID);
       SetFullName(FN);
       SetNationality(Nat);
       SetDOB(DOB);
       SetHomeAddress(home);
       SetTown(town);
       SetDistrict(district);
       SetJob(job);
       SetBirthAddress(birthAdd);
       SetRecordID(recordID);
       SetFather(father);
       SetMother(mother);
       SetReligion(rel);
       SetGender(gender);
       SetMaritalStatus(MS);
       Apply();

    }
}
