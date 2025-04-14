package org.example.playwright;

import com.microsoft.playwright.options.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;

public class UserMainLogINFlowTest extends BaseTest {

    @Test(priority = 1)
    public void registerNewUser() {
        navigateTo("https://www.neweracap.com/account/register");
        if (registrationPage == null) {
            registrationPage = new RegistrationPage(page);
        }
        registrationPage.creationOfNewUser();
    }

    @Test(priority = 2)
    public void logInWithNewUser() {
        navigateTo("https://www.neweracap.com/account/login");
        if (loginPage == null) {
            loginPage = new LoginPage(page);
        }
        loginPage.logInOfNewUser();

        // Debug: Verify successful login before saving cookies
        boolean isLoginSuccess = page.locator("xpath=//a[@href='/account' and @title='Account']").isVisible();
        if (isLoginSuccess) {
            System.out.println("Login successful, saving cookies...");
            CookieUtils.saveCookies(page, "cookies.json");
        } else {
            System.err.println("Login failed. Cookies will not be saved.");
        }
    }

    @Test(priority = 3)
    public void goToAccountDetailsPage() {
        CookieUtils.loadCookies(page);
        // Verify that cookies are applied
        List<Cookie> loadedCookies = page.context().cookies();
        System.out.println("Loaded cookies: ");
        for (Cookie cookie : loadedCookies) {
            System.out.println("- " + cookie.name + "=" + cookie.value);
        }

        // Navigate to Account Details
        navigateTo("https://www.neweracap.com/account");
        if (accountDetails == null) {
            accountDetails = new AccountDetails(page);
        }

        accountDetails.checkAccountDetails(); // Ensure this method performs necessary checks
    }

    @AfterMethod
    public void clearCookies() {
        page.context().clearCookies();
        System.out.println("Cookies cleared after the test.");
    }
}