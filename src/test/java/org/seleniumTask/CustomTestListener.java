package org.seleniumTask;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;

public class CustomTestListener extends NewEraBaseTest implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance(); // This gives you the test class instance
        if (testInstance instanceof NewEraBaseTest) {
            WebDriver driver = ((NewEraBaseTest) testInstance).driver;
            if (driver != null) {
                try {
                    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
                    File destFile = new File("./Screenshots/" + result.getMethod() + ".jpg");
                    FileUtils.copyFile(sourceFile, destFile);
                    System.out.println("Screenshot saved successfully.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Driver is null. Cannot take screenshot!");
            }
        }
        System.out.println(result.getName() + " failed!");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " started!");
    }
}
