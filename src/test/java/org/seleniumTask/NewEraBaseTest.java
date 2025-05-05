package org.seleniumTask;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewEraBaseTest {


    protected WebDriver driver ;

    @Before
    public void setUp(){
        LoggerUtility.info("Starting the Selenium driver...");
        LoggerUtility.debug("Initialized ChromeDriver");
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("136.0.7103.49");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        LoggerUtility.info("Navigated to https://www.neweracap.com/account/login");
        driver.get("https://www.neweracap.com/account/login");
    }

    @BeforeTest
    public void setLoggerBeforeTestWillStart(){
        LoggerUtility.info("Starting the test ");
    }

    @AfterTest
    public void setLoggerAfterTestWillFinished(){
        LoggerUtility.info("The test was finished ");
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
