package org.example.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private Playwright playwright;
    private Browser browser;

    protected Page page;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected AccountDetails accountDetails;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    protected void navigateTo(String url) {
        page.navigate(url);
    }

    @AfterClass
    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}