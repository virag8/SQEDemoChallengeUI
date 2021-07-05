package com.sample.test.demo.framework;

import static org.testng.Assert.fail;

import com.sample.test.demo.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;
    private String driverKey;
    private String driverPath;

    public String getDriverKey() {
        return driverKey;
    }

    public void setDriverKey(String driverKey) {
        this.driverKey = driverKey;
    }


    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }
//TODO relaunch driver if driver is null in between tests

    @BeforeClass(alwaysRun = true)
    public void init() throws CustomTestException {
        try {
            config = new Configuration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = config.getUrl();
        initializeDriver();
        navigateToSite();
    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void initializeDriver() throws CustomTestException {
        try {
            String browserBeanId = String.format("%s-%s", config.getBrowser(), config.getPlatform());
            Log.info("config.getBrowser()-config.getPlatform(): " + browserBeanId);

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("browsers-beans.xml");
            TestBase testBase = applicationContext.getBean(browserBeanId, TestBase.class);
            System.setProperty(testBase.getDriverKey(), testBase.getDriverPath());
            this.driver = applicationContext.getBean(config.getBrowser(), WebDriver.class);
        } catch (NoSuchBeanDefinitionException e) {
            throw new CustomTestException(String.format("Unsupported browser: %s or platform: %s", config.getBrowser(), config.getPlatform()), e);
        }

    }
}
