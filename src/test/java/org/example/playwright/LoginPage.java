package org.example.playwright;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page loginPage;

    public LoginPage(Page loginPage) {
        this.loginPage = loginPage;
    }

    private String email = "xpath=//input[@id='CustomerEmail']";
    private String password = "xpath=//input[@id='CustomerPassword']";
    private String loginButton = "xpath=//button[@class='login-page__sign-in-button']";

    private void enterEmailToLoginForm() {
        loginPage.locator(email).fill("testli@yopmail.com");
    }

    private void enterPasswordToLoginForm() {
        loginPage.locator(password).fill("Test123!");
    }

    public void clickLoginButton() {
        loginPage.locator(loginButton).click();
    }

    public void logInOfNewUser() {
        enterEmailToLoginForm();
        enterPasswordToLoginForm();
        clickLoginButton();
        System.out.println("User authenticated and auth state saved.");
    }
}