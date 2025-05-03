package org.seleniumTask;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewEraBaseTest {

    protected WebDriver driver ;


    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("136.0.7103.49");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.neweracap.com/account/login");
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }
}
