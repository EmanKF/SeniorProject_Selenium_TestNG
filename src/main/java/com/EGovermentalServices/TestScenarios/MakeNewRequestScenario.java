package com.EGovermentalServices.TestScenarios;

import com.EGovermentalServices.DBConnection.SQLConnector;
import com.EGovermentalServices.PageObject.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MakeNewRequestScenario {

    public static final Logger log = Logger.getLogger(MakeNewRequestScenario.class.getName());
    String driverPath="C:\\SeleniumNew\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    HomePage homeObj;
    RegistrationPage regObj;
    LoginPage loginObj;
    ServicesPage servPage;
    NewRequestPage newReqPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://localhost:8090/htmlfiles/home.html");

    }

    @Test(priority = 0)
    public void Homepage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homePage")));
        log.info("Go To Login Page ..");
        homeObj = new HomePage(driver);
        homeObj.GotoLogin();
    }



    //This method is to Registrate in the application


    public void RegistrateToApplcation(){

        //create registration page object
        regObj = new RegistrationPage(driver);
        log.info("Add info to create new account ..");
        //registrate to application
        regObj.Register("EmanKDF","10000123","00961","81704401","eman.farroukh@gmail.com","123456789","123456789");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertTrue(alert.getText().contains("registration success"));
            softAssert.assertAll();
        } catch (Exception e) {
            //exception handling
        }
    }

    @Test(priority = 2)
    public void LoginAfterRegistration(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        loginObj = new LoginPage(driver);
        log.info("Add username,password & login to your account ..");
        loginObj.login("EmanKF","123456789");
    }

    @Test(priority = 3)
    public void MakeRequest(){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNewRequest")));
        log.info("Services page is displayed ..");
        servPage = new ServicesPage(driver);
        log.info("Click Make New Request button ..");
        servPage.MakeNewRequest();
    }

    @Test(priority = 4)
    public void ApplyRequest() throws SQLException, ClassNotFoundException {

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Certificate")));
        log.info("New Request Page is displayed ..");
        newReqPage = new NewRequestPage(driver);
        log.info("Choose a certificate, add your Identification ID and click Check button ..");
        log.info("Add your birth address, town & distict ..");
        newReqPage.CheckID("FamilyCivilRegistration", "10000123","Saidaa","Kfarchouba","Hasbaya","C:\\Users\\user\\Pictures\\Screenshots\\LoginPage.png");

        log.info("Check if FullName is not null ..");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.id("txtFname")), "value"));
        log.info("Click Apply button ..");
        newReqPage.Apply();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Request Successfully Sent"));
        log.info("Click OK on displayed alert ..");
        alert.accept();
        log.info("Go to Services Page ..");
        softAssert.assertAll();

    }
}
