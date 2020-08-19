package com.EGovermentalServices.TestCases;

import com.EGovermentalServices.PageObject.HomePage;
import com.EGovermentalServices.PageObject.LoginPage;
import com.EGovermentalServices.PageObject.RegistrationPage;
import com.EGovermentalServices.PageObject.ServicesPage;
import com.EGovermentalServices.TestScenarios.MakeNewRequestScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HomeTestCase {

    public static final Logger log = Logger.getLogger(MakeNewRequestScenario.class.getName());
    String driverPath="C:\\SeleniumNew\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    HomePage homeObj;

    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://localhost:8090/htmlfiles/home.html");

    }


    public void Login(){

        homeObj = new HomePage(driver);
        homeObj.GotoLogin();

    }

    @Test(priority = 0)
    public void SignUp(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homePage")));
        homeObj = new HomePage(driver);
        homeObj.GotoSignUp();

    }
}
