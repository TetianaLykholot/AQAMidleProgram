package org.seleniumTask;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners({com.epam.reportportal.testng.ReportPortalTestNGListener.class, CustomTestListener.class})
public class NewEraLoginTest extends NewEraBaseTest {

    private LogInPage loginPage;
    private Products products;

    @BeforeMethod
    public void initializePageObjects() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Check test setup.");
        }
        loginPage = new LogInPage(driver);
        products = new Products(driver);
    }


    @Epic("Regression Test")
    @Feature("Login Test")
    @Severity(SeverityLevel.BLOCKER)
    @Description ("Test Description: Login test with correct user name and password ")
    @Step("Step 1: Navigate to Login Page")
    @Test(priority = 1, description = "Valid login to New Era", testName = "Login")
    public void testValidLogin()  {
        loginPage.login();
    }

    @Description ("Test Description: Adding product to the cart ")
    @Feature("Cart Page")
    @Step("Step: add products to the bag ")
    @Test(testName = "Adding to basket test")
    public void addProductToBasket()  {
        products.addToBag();
    }
}
