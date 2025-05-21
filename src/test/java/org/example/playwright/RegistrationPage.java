package org.example.playwright;

import com.microsoft.playwright.Page;

public class RegistrationPage {

    private Page registrationPage;

    private String firstName = "xpath=//input[@id='RegisterForm-FirstName']";
    private String lastName = "xpath=//input[@id='RegisterForm-LastName']";
    private String email = "xpath=//input[@id='RegisterForm-email']";
    private String dateOfBirth = "xpath=//input[@id='RegisterForm-birthday']";
    private String password = "xpath=//input[@id='RegisterForm-password']";
    private String createYourAccountButton = "xpath=//button[contains(@class, 'register-page__submit-button')]";

    public RegistrationPage(Page registrationPage) {
        this.registrationPage = registrationPage;
    }

    private void enterFirstName() {
        registrationPage.locator(firstName).fill("Test");
    }

    private void enterLasttName() {
        registrationPage.locator(lastName).fill("TestLastname");
    }

    private void enterEmail() {
        String uniqueEmail = "testli_" + System.currentTimeMillis() + "@yopmail.com";
        System.out.println("Generated Email: " + uniqueEmail);
        registrationPage.locator(email).fill(uniqueEmail);
    }

    private void setDateOfBirth() {
        registrationPage.locator(dateOfBirth).fill("08/09/1996");
    }

    private void enterPassword() {
        registrationPage.locator(password).fill("Test123!");
    }


    private void clickSignInButton() {
        registrationPage.locator(createYourAccountButton).click();
    }

    public void creationOfNewUser() {
        enterFirstName();
        enterLasttName();
        enterEmail();
        setDateOfBirth();
        enterPassword();
        clickSignInButton();
    }
}
