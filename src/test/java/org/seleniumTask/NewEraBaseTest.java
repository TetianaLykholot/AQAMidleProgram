package org.seleniumTask;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class NewEraBaseTest {


    protected WebDriver driver ;

    @BeforeMethod
    @Step("Setting up WebDriver")
    public void setUp(){
        LoggerUtility.info("Starting the Selenium driver...");
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Users/VLYKHTE/Desktop/untitled folder/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security", "--allow-insecure-localhost");
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

    @After
    @Step("Tearing down WebDriver")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
