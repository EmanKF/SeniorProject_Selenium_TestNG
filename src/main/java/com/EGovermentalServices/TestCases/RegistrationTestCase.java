package com.EGovermentalServices.TestCases;

import com.EGovermentalServices.PageObject.LoginPage;
import com.EGovermentalServices.PageObject.RegistrationPage;
import com.EGovermentalServices.PageObject.ServicesPage;
import com.EGovermentalServices.TestScenarios.MakeNewRequestScenario;
import org.openqa.selenium.Alert;
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

public class RegistrationTestCase {

    public static final Logger log = Logger.getLogger(MakeNewRequestScenario.class.getName());
    String driverPath="C:\\SeleniumNew\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    RegistrationPage regObj;
    SoftAssert softAssert = new SoftAssert();


    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://localhost:8090/htmlfiles/register.html");

    }

    //This method is to Registrate in the application

    @Test(priority = 0)
    public void RegistrateToApplcation(){

//create registration page object
        regObj = new RegistrationPage(driver);
        log.info("Add info to create new account ..");
        //registrate to application
        regObj.Register("EmanKHF","10000123","00961","81704401","eman.farroukh@gmail.com","123456789","123456789");
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


}
