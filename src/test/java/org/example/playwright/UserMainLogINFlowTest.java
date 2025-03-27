package org.example.playwright;

import com.microsoft.playwright.options.Cookie;
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
        CookieUtils.saveCookies(page, "cookies.json");
    }

    @Test(priority = 3)
    public void goToAccountDetailsPage() {
        //     Load cookies into the browser context
        if (accountDetails == null) {
            accountDetails = new AccountDetails(page);
        }
        CookieUtils.loadCookies(page, "cookies.json");

        // Perform verification: Ensure cookies are loaded
        List<Cookie> loadedCookies = page.context().cookies();
        System.out.println("Loaded cookies: ");
        for (Cookie cookie : loadedCookies) {
            System.out.println("- " + cookie.name + "=" + cookie.value);
        }

        accountDetails.checkAccountDetails();
    }
}
