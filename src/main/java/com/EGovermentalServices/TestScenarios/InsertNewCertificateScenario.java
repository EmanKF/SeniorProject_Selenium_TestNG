package com.EGovermentalServices.TestScenarios;

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

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InsertNewCertificateScenario {

    public static final Logger log = Logger.getLogger(InsertNewCitizenScenario.class.getName());
    String driverPath="C:\\SeleniumNew\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    HomePage homeObj;
    LoginPage loginObj;
    ServicesPage servPage;
    NewCertificatePage newCertObj;
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

    @Test(priority = 1)
    public void Login(){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        loginObj = new LoginPage(driver);
        log.info("Add username,password & login to your account ..");
        loginObj.login("EmanKF","123456789");
    }

    @Test(priority = 2)
    public void GoToServices(){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefNewCit")));
        log.info("Services page is displayed ..");
        servPage = new ServicesPage(driver);
        log.info("Click Insert/Update Certificate href ..");
        servPage.InsertUpdateCertificate();
    }

    @Test(priority = 3)
    public void InsertCertificate(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newCert")));
        log.info("Insert/Update Certificate page is displayed ..");
        newCertObj = new NewCertificatePage(driver);
        log.info("Click Add New Certificate href ..");
        log.info("Add Certifcate title,details and click ADD button to add new certificate ..");
        newCertObj.AddNewCertificate("Identification Cards","Add your Individual registration");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Certificate Successfully Inserted"));
        log.info("Click OK on displayed alert ..");
        alert.accept();
        softAssert.assertAll();
    }

}

