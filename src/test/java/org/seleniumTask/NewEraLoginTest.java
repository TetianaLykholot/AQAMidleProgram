package org.seleniumTask;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Epic("Regression Test")
@Feature("Login Test")
@Severity(SeverityLevel.BLOCKER)
@Listeners({com.epam.reportportal.testng.ReportPortalTestNGListener.class, CustomTestListener.class})
public class NewEraLoginTest  extends  NewEraBaseTest{


    @Description("Valid login with correct credentials")
    @Test(description = "Test valid login to New Era")
    public void test() {
        Allure.step("Step 2: Open browser");
        System.out.println("This is a test method.");
    }



    private LogInPage loginPage;
//    private Products products;

    @BeforeMethod
    public void initializePageObjects() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Check test setup.");
        }
        loginPage = new LogInPage(driver);
//        products = new Products(driver);
    }


    @Description ("Test Description: Login test with correct user name and password ")
    @Test(priority = 1, description = "Valid login to New Era", testName = "Login")

    public void testValidLogin()  {
        Allure.step("Step 1: Open browser");
        loginPage.login();
    }
//
//    @Description ("Test Description: Adding product to the cart ")
//    @Feature("Cart Page")
//    @Step("Step: add products to the bag ")
//    @Test(testName = "Adding to basket test")
//    public void addProductToBasket()  {
//        products.addToBag();
//    }
}
