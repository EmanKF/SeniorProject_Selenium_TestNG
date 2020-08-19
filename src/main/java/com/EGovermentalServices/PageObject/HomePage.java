package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage GotoLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefLogin")));
        driver.findElement(By.id("hrefLogin")).click();
        return new LoginPage(driver);
    }

    public RegistrationPage GotoSignUp(){

        driver.findElement(By.id("hrefSignup")).click();
        return new RegistrationPage(driver);
    }
}
