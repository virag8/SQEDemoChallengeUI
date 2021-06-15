package com.sample.test.demo.framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Log.debug("The name of the testcase started is: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.debug("The name of the testcase passed is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.debug("The name of the testcase failed is: " + result.getName());
        WebDriver driver = (WebDriver) result.getAttribute("driver");
        if (driver != null){
            new SeleniumBase(driver).CaptureScreenShot();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.debug("The name of the testcase skipped is: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        Log.debug("The name of the execution started is: " + context.getOutputDirectory());
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.debug("The name of the execution finished is: " + context.getOutputDirectory());
    }
}
