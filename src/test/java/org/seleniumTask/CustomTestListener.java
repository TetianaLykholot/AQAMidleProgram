package org.seleniumTask;
import org.testng.ITestResult;

import org.testng.ITestListener;

public class CustomTestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " failed!");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " started!");
    }
}
