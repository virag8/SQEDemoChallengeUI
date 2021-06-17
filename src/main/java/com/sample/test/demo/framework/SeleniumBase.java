package com.sample.test.demo.framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class SeleniumBase {
    private WebDriver driver;

    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    public Select dropDown(WebElement element) {
        return new Select(element);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void captureScreenShot() {
        try {
            String base64 = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BASE64);
            Reporter.log("<br><img src='data:image/png;base64, " + base64 + "' height='300' width='300'/><br>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
}
