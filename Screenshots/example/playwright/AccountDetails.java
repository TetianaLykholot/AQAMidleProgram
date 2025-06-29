package org.example.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class AccountDetails {

    private Page accountDetails;
    private String userIconAccount = "xpath=//a[@href='/account' and @title='Account']";
    private Locator accountIntro;

    public AccountDetails(Page accountDetails) {
        this.accountDetails = accountDetails;
    }

    private void initializeAccountIntro() {
        if (accountIntro == null) {
            accountIntro = accountDetails.locator("xpath=/descendant::div[@class='ne-account__details']//p[contains(text(), 'Welcome')]");
        }

    }

    private void clickUserIconAcccount() {
        accountDetails.locator(userIconAccount).click();
    }

    public void checkAccountDetails() {
        initializeAccountIntro();
        clickUserIconAcccount();
        String welcomeText = accountIntro.innerText();
        Assert.assertEquals(welcomeText, "Welcome back, Test");
    }
}
