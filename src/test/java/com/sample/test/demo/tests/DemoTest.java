package com.sample.test.demo.tests;

import com.sample.test.demo.framework.CustomTestException;
import com.sample.test.demo.constants.PizzaData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sample.test.demo.framework.TestBase;

import static com.sample.test.demo.steps.PositiveSteps.BookPizzaWithRandomPizzaInputs;


public class DemoTest extends TestBase {
    @BeforeMethod
    public void beforeMethodBlock(ITestResult result) {
        result.setAttribute("driver", driver);
    }

    @Test
    public void demoTest() throws CustomTestException {
        try {
            System.out.println("HELLO WORLD");
            PizzaData pizzaData = new PizzaData(1, 111111111, "Harry", "abc@amail.com");
            pizzaData
                    .setRandomPizzaPayment()
                    .setRandomPizzaType()
                    .setRandomPizzaTopping1()
                    .setRandomPizzaTopping2();

            BookPizzaWithRandomPizzaInputs(driver, pizzaData);

        } catch (Exception e) {
            throw new CustomTestException("Test Exception", e);
        }

    }

}
