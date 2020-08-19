package com.EGovermentalServices.PageFactory;

import com.EGovermentalServices.PageObject.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFactory {


    WebDriver driver;

    @FindBy(name = "txtUname")

    WebElement username;

    @FindBy(name = "txtid")

    WebElement identificationID;

    @FindBy(name = "PhoneCode")

    WebElement phoneCode;

    @FindBy(name = "txtPhone")

    WebElement phoneNb;

    @FindBy(name = "txtEmail")

    WebElement email;

    @FindBy(name = "txtPass")

    WebElement password;

    @FindBy(name = "txtCpass")

    WebElement Cpassword;

    @FindBy(name = "btnSignUp")

    WebElement btnRegister;

    public RegistrationPageFactory(WebDriver driver) {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void SetUserName(String userID) {
        username.sendKeys(userID);
    }

    public void SetIdentificationID(String txtID) {
        identificationID.sendKeys(txtID);
    }

    public void SetUPhoneCode(String Pcode) {
        phoneCode.sendKeys(Pcode);
    }

    public void SetPhoneNumber(String PhoneNb) {
        phoneNb.sendKeys(PhoneNb);
    }

    public void SetEmail(String Email) {
        email.sendKeys(Email);
    }

    public void SetPassword(String pass) {
        password.sendKeys(pass);
    }

    public void SetConfPassword(String Cpass) {
        Cpassword.sendKeys(Cpass);
    }

    public void submitRegistration() {
        btnRegister.click();
    }

    public void Register(String UN, String ID, String Pcode, String Pnum, String Email, String password, String Cpass) {
        SetUserName(UN);
        SetIdentificationID(ID);
        SetUPhoneCode(Pcode);
        SetPhoneNumber(Pnum);
        SetEmail(Email);
        SetPassword(password);
        SetConfPassword(Cpass);
        submitRegistration();
//        driver.switchTo().alert().accept(); // To click on the "OK" button of the alert

    }
}

