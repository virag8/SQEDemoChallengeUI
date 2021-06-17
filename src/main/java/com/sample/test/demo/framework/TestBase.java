package com.sample.test.demo.framework;

import static org.testng.Assert.fail;

import com.sample.test.demo.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;

    //TODO relaunch driver if driver is null in between tests

    @BeforeClass(alwaysRun = true)
    public void init() {
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

    private void initializeDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else {
            fail("Unsupported browser " + config.getBrowser());
        }

    }
}
