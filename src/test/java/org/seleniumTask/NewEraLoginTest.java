package org.seleniumTask;
import org.junit.Test;

public class NewEraLoginTest extends NewEraBaseTest {

    LogInPage loginPage = new LogInPage();
    Products products = new Products();;

    @Test
    public void testValidLogin()  {
        loginPage.login();
    }

    @Test
    public void addProductToBasket()  {
        products.addToBag();
    }
}
