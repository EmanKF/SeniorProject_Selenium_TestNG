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

public class UpdateUserSkillsScenario {

    public static final Logger log = Logger.getLogger(UpdateUserSkillsScenario.class.getName());
    String driverPath="C:\\SeleniumNew\\ChromeDriver\\chromedriver.exe";
    WebDriver driver;
    HomePage homeObj;
    LoginPage loginObj;
    ServicesPage servPage;
   UpdateSkillsPage updateskillObj;
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
        log.info("Go to Login Page ..");
        homeObj = new HomePage(driver);
        homeObj.GotoLogin();
    }

    @Test(priority = 1)
    public void Login(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        loginObj = new LoginPage(driver);
        log.info("Add username & password and click Login button ..");
        loginObj.login("EmanKF","123456789");
    }

    @Test(priority = 2)
    public void GoToServices(){
        log.info("Go to Services Page ..");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefNewCit")));
        servPage = new ServicesPage(driver);
        log.info("Click on Update skill href ..");
        servPage.UpdateSkill();
    }

    @Test(priority = 3)
    public void UpdateSkills(){
        log.info("Update skill page in displayed ..");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUName")));
       updateskillObj = new UpdateSkillsPage(driver);
       log.info("Enter username to change its skill & enter the new skill ..");
       updateskillObj.UpdateSkill("rama","Admin");
       log.info("Click Apply button to save changes..");
       updateskillObj.Apply();
        Assert.assertEquals(driver.findElement(By.id("txtUName")).getAttribute("value"), "EmanFF");
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Skill Successfully Updated"));
        alert.accept();
        log.info("Go to Services Page ..");
        softAssert.assertAll();


    }


}
