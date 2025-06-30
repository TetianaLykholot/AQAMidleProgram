package org.seleniumTask;

import io.qameta.allure.Step;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewEraBaseTest {

    protected WebDriver driver ;

    @BeforeClass
    @Step("Setting up WebDriver")
    public void setUp(){
        LoggerUtility.info("Starting the Selenium driver...");
        WebDriverManager.chromedriver().setup();
       System.setProperty("webdriver.chrome.driver", "/Users/VLYKHTE/Desktop/untitled folder/chromedriver-mac-arm64/chromedriver");
        WebDriverManager.chromedriver().driverVersion("138.0.7204.x").setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        LoggerUtility.info("Navigated to https://www.neweracap.com/account/login");
        driver.get("https://www.neweracap.com/account/login");

        LoggerUtility.info("WebDriver setup complete.");
    }

    @BeforeTest
    public void setLoggerBeforeTestWillStart(){
        LoggerUtility.info("Starting the test ");
    }

    @AfterTest
    public void setLoggerAfterTestWillFinished(){
        LoggerUtility.info("The test was finished ");
    }

    @AfterClass
    @Step("Tearing down WebDriver")
    public void tearDown() {
            driver.quit();
        }
}
