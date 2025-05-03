package org.seleniumTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.IOException;

public class LogInPage extends NewEraBaseTest   {

    private By emailField = By.id("CustomerEmail"); // Replace with correct locator
//    private By passwordField = By.id("CustomerPassword"); // Replace with correct locator
    private By loginButton = By.className("login-page__sign-in-button"); // Replace with correct locator



    public void LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail() {
        driver.findElement(emailField).sendKeys("testli@yopmail.com");
    }

    public void enterPassword() {
        WebElement passwordField = driver.findElement(
                RelativeLocator.with(By.tagName("input")).below(emailField));
        passwordField.sendKeys("Test123!");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }



    public void login(){
        enterEmail();
        enterPassword();
        clickLogin();
    }


}
