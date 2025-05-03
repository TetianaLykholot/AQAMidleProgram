package org.seleniumTask;

import org.junit.Test;

public class NewEraLoginTest extends NewEraBaseTest{
    LogInPage loginPage = new LogInPage();

    @Test
    public void loginTest(){
        setUp();
        loginPage.login();
        closeDriver();

    }

}
