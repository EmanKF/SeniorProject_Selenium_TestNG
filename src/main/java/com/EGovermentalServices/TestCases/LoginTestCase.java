package com.EGovermentalServices.TestCases;

import com.EGovermentalServices.PageObject.LoginPage;
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

public class LoginTestCase {

    public static final Logger log = Logger.getLogger(MakeNewRequestScenario.class.getName());
    String driverPath = "C:\\SeleniumNew\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    LoginPage loginObj;

    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://localhost:8090/htmlfiles/login.html");

    }

    // This method is to login to the application

    @Test(priority = 0)
    public void LoginToApplication(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        loginObj = new LoginPage(driver);
        log.info("Add username,password & login to your account ..");
        loginObj.login("EmanKF","123456789");

    }

}
