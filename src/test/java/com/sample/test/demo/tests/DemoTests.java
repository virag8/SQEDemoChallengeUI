package com.sample.test.demo.tests;

import com.sample.test.demo.assertions.NegativeAssertions;
import com.sample.test.demo.assertions.PositiveAssertions;
import com.sample.test.demo.constants.PizzaOutputdata;
import com.sample.test.demo.framework.CustomTestException;
import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.steps.DemoSteps;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sample.test.demo.framework.TestBase;

public class DemoTests extends TestBase {
    DemoSteps demoSteps;
    PizzaInputdata pizzaInputData;

    @BeforeMethod(alwaysRun = false)
    public void beforeMethodBlock(ITestResult result) {
        result.setAttribute("driver", driver);
        demoSteps = new DemoSteps(driver);

        pizzaInputData = new PizzaInputdata("111111111", "Harry", "abc@amail.com");
    }

    @Test(enabled = true, groups = {"regression", "boundary"})
    public void demoValidHighQuantityTest() throws CustomTestException {
        final String QUANTITY = "100000";

        try {
            //Preparing the test data for the testcase
            pizzaInputData
                    .setQuantity(QUANTITY)
                    .setRandomPizzaPayment()
                    .setRandomPizzaType()
                    .setRandomUniquePizzaToppings();

            //Executing the flow for the testcase on AUT
            String pizzaCost = demoSteps.FillPizzaInputs(pizzaInputData);
            String bookOrderMessage = demoSteps.ConfirmOrder(false);

            //Validating the UI Response for the testcase as per expected
            PizzaOutputdata pizzaOutputdata = new PizzaOutputdata(bookOrderMessage, pizzaCost);
            PositiveAssertions.verifyValidOrder(pizzaInputData, pizzaOutputdata);

        } catch (Exception e) {
            throw new CustomTestException("Test Exception", e);
        }
    }

    @Test(invocationCount = 2, enabled = true, groups = {"sanity"})
    public void demoValidRandomInputsTest() throws CustomTestException {
        try {
            //Preparing the test data for the testcase
            pizzaInputData
                    .setRandomQuantity()
                    .setRandomPizzaPayment()
                    .setRandomPizzaType()
                    .setRandomUniquePizzaToppings();

            //Executing the flow for the testcase on AUT
            String pizzaCost = demoSteps.FillPizzaInputs(pizzaInputData);
            String bookOrderMessage = demoSteps.ConfirmOrder(true);

            //Validating the UI Response for the testcase as per expected
            PizzaOutputdata pizzaOutputdata = new PizzaOutputdata(bookOrderMessage, pizzaCost);
            PositiveAssertions.verifyValidOrder(pizzaInputData, pizzaOutputdata);

        } catch (Exception e) {
            throw new CustomTestException("Test Exception", e);
        }
    }

    @Test(dataProvider = "MultipleInvalidQuantity", enabled = true, groups = {"sanity", "regression", "negative"})
    public void demoInvalidQuantityTest(Object quantity) throws CustomTestException {
        try {

            //Preparing the test data for the testcase
            pizzaInputData
                    .setQuantity(String.valueOf(quantity))
                    .setRandomPizzaPayment()
                    .setRandomPizzaType()
                    .setRandomUniquePizzaToppings();

            //Executing the flow for the testcase on AUT
            String pizzaCost = demoSteps.FillPizzaInputs(pizzaInputData);
            String bookOrderMessage = demoSteps.ConfirmOrder(false);

            //Validating the UI Response for the testcase as per expected
            PizzaOutputdata pizzaOutputdata = new PizzaOutputdata(bookOrderMessage, pizzaCost);
            NegativeAssertions.verifyInvalidIntegerQuantity(pizzaInputData, pizzaOutputdata);

        } catch (Exception e) {
            throw new CustomTestException("Test Exception", e);
        }
    }


    @DataProvider(name = "MultipleInvalidQuantity")
    public Object[][] MultipleInvalidQuantity() {
        return new Object[][]{
                {0},
                {-2},
                {"abc"},
        };
    }

}
