package org.seleniumTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NewEraBaseTest {

    static WebDriver driver ;


    public static void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "135.0.7049.114");
        capabilities.setCapability("platform", "WINDOWS");
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("https://www.neweracap.com/account/login");
    }

    public static void closeDriver(){
        driver.quit();
    }
}
