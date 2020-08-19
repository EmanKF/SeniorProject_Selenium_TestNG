package com.EGovermentalServices.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateSkillsPage {

    private final WebDriver driver;
    private WebElement username;

    public UpdateSkillsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement SetUserName(String UN) {
        username = driver.findElement(By.id("txtUName"));
        username.sendKeys(UN);
        return username;
    }

    public void ChangeToUser(){

        driver.findElement(By.id("user")).click();
    }

    public void ChangeToEmployee(){

        driver.findElement(By.id("employee")).click();
    }

    public void ChangeToAdmin(){

        driver.findElement(By.id("admin")).click();
    }


    public ServicesPage Apply(){

        driver.findElement(By.id("btnApply")).click();
        return new ServicesPage(driver);
    }

    public void UpdateSkill(String UN,String skill){
        SetUserName(UN);
        if(skill.equals("User")){
            ChangeToUser();
        }
        else if(skill.equals("Employee")){
            ChangeToEmployee();
        }
        else if(skill.equals("Admin")){
            ChangeToAdmin();
        }
    }

}
