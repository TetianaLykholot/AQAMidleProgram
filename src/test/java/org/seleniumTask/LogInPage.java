package org.seleniumTask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {


    @FindBy(id = "CustomerEmail")
    WebElement emailField ;

    @FindBy(id = "CustomerPassword")
    WebElement passwordField ;

    @FindBy(className = "login-page__sign-in-button")
    WebElement loginButton;


    public void login(){
        emailField.sendKeys("testli@yopmail.com");
        passwordField.sendKeys("Test123!");
        loginButton.click();
    }

}
