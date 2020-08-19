package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;
    private WebElement username;
    private WebElement IdentificationID;
    private WebElement PhoneCode;
    private WebElement PhoneNumber;
    private WebElement Email;
    private WebElement password;
    private WebElement ConfPass;

    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement SetUsername(String UN) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUname")));
        username = driver.findElement(By.id("txtUname"));
        username.sendKeys(UN);
        return username;
    }
    public WebElement SetIdentificationID(String txtID) {
        IdentificationID = driver.findElement(By.id("txtid"));
        IdentificationID.sendKeys(txtID);
        return IdentificationID;
    }
    public WebElement SetUPhoneCode(String Pcode) {
        PhoneCode = driver.findElement(By.id("PhoneCode"));
        PhoneCode.sendKeys(Pcode);
        return PhoneCode;
    }
    public WebElement SetPhoneNumber(String PhoneNb) {
        PhoneNumber = driver.findElement(By.id("txtPhone"));
        PhoneNumber.sendKeys(PhoneNb);
        return PhoneNumber;
    }
    public WebElement SetEmail(String email) {
        Email = driver.findElement(By.id("txtEmail"));
        Email.sendKeys(email);
        return Email;
    }
    public WebElement SetPassword(String pass) {
        password = driver.findElement(By.id("txtPass"));
        password.sendKeys(pass);
        return password;
    }
    public WebElement SetConfPassword(String Cpass) {
        ConfPass = driver.findElement(By.id("txtCpass"));
        ConfPass.sendKeys(Cpass);
        return ConfPass;
    }
    public LoginPage submitRegistration()
    {
        driver.findElement( By.id("btnSignUp")).click();
        return new LoginPage(driver);
    }

    public void Register(String UN, String ID, String Pcode, String Pnum, String email, String password, String Cpass) {
        SetUsername(UN);
        SetIdentificationID(ID);
        SetUPhoneCode(Pcode);
        SetPhoneNumber(Pnum);
        SetEmail(email);
        SetPassword(password);
        SetConfPassword(Cpass);
        submitRegistration();

    }
}
