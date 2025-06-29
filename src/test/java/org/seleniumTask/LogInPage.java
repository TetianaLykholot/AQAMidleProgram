package org.seleniumTask;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LogInPage  {

//   private WebDriver driver;
//
//   public LogInPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    private By emailField = By.id("CustomerEmail");
//    private By loginButton = By.className("login-page__sign-in-button");
//
//    public void enterEmail() {
//        driver.findElement(emailField).sendKeys("testli@yopmail.com");
//    }
//
//    @Step("Step 1: Navigate to Login Page")
//    public void enterPassword() {
//        WebElement passwordField = driver.findElement(
//                RelativeLocator.with(By.tagName("input")).below(emailField));
//        passwordField.sendKeys("Test123!");
//    }
//
//    public void clickLogin() {
//        driver.findElement(loginButton).click();
//    }
//
//    @Step("Login to the page")
//    public void login(){
//        enterEmail();
//        enterPassword();
//        clickLogin();
//    }
}
