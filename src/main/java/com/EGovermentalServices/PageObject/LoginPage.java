package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private WebElement username;
    private WebElement password;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement SetUsername(String UN) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUName")));
        username = driver.findElement(By.id("txtUName"));
        username.sendKeys(UN);
        return username;
    }

        public WebElement SetPassword(String pass) {
        password = driver.findElement(By.id("txtPass"));
        password.sendKeys(pass);
        return password;
    }

    public ServicesPage clickLoginSubmit(){
        driver.findElement(By.id("btnLogin")).click();
        return new ServicesPage(driver);
    }

    public void login(String UN, String pass) {
        SetUsername(UN);
        SetPassword(pass);
        clickLoginSubmit();

    }
}
