package org.seleniumTask;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class NewEraLoginTest extends LogInPage{



    @Test
    public void testValidLogin()  {
        // Pass the driver from BaseTest to LoginPage
        login();
    }

}
