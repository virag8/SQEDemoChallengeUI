package com.sample.test.demo.tests;

import com.sample.test.demo.assertions.DemoTestAssertions;
import com.sample.test.demo.assertions.IDemoTestAssertions;
import com.sample.test.demo.constants.PizzaOutputdata;
import com.sample.test.demo.framework.CustomTestException;
import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.steps.DemoSteps;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sample.test.demo.framework.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoTests extends TestBase {
    DemoSteps demoSteps;
    PizzaInputdata pizzaInputData;
    public static final String SUCCESSFUL_MESSAGE = "Thank you for your order!";
    public static final String COST_TOTAL = "TOTAL:";

    @BeforeMethod(alwaysRun = true)
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

            //Configuring list of assertions for the testcase
            List<IDemoTestAssertions> assertions = new ArrayList<>();
            Collections.addAll(assertions,
                    DemoTestAssertions.assertionPizzaCostInTextBox,
                    DemoTestAssertions.assertionSuccessfulOrderMessage,
                    DemoTestAssertions.assertionPizzaCostInDialog,
                    DemoTestAssertions.assertionPizzaTypeInDialog);

            //Executing the flow for the testcase on AUT
            String pizzaCost = demoSteps.FillPizzaInputs(pizzaInputData);
            String bookOrderMessage = demoSteps.ConfirmOrder(false);

            //Validating the UI Response for the testcase as per expected
            applyAssertions(assertions, pizzaCost, bookOrderMessage);

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

            //Configuring list of assertions for the testcase
            List<IDemoTestAssertions> assertions = new ArrayList<>();
            Collections.addAll(assertions,
                    DemoTestAssertions.assertionPizzaCostInTextBox,
                    DemoTestAssertions.assertionSuccessfulOrderMessage,
                    DemoTestAssertions.assertionPizzaCostInDialog,
                    DemoTestAssertions.assertionPizzaTypeInDialog);

            //Executing the flow for the testcase on AUT
            String pizzaCost = demoSteps.FillPizzaInputs(pizzaInputData);
            String bookOrderMessage = demoSteps.ConfirmOrder(true);

            //Validating the UI Response for the testcase as per expected
            applyAssertions(assertions, pizzaCost, bookOrderMessage);

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

            //Configuring list of assertions for the testcase
            List<IDemoTestAssertions> assertions = new ArrayList<>();
            Collections.addAll(assertions,
                    DemoTestAssertions.assertionInvalidPizzaCostInTextBox,
                    DemoTestAssertions.assertionInvalidSuccessInDialog);

            //Executing the flow for the testcase on AUT
            String pizzaCost = demoSteps.FillPizzaInputs(pizzaInputData);
            String bookOrderMessage = demoSteps.ConfirmOrder(false);

            //Validating the UI Response for the testcase as per expected
            applyAssertions(assertions, pizzaCost, bookOrderMessage);

        } catch (Exception e) {
            throw new CustomTestException("Test Exception", e);
        }
    }

    private void applyAssertions(List<IDemoTestAssertions> assertions, String pizzaCost, String bookOrderMessage) {
        PizzaOutputdata pizzaOutputdata = new PizzaOutputdata(bookOrderMessage, pizzaCost);
        for (IDemoTestAssertions IDemoTestAssertions : assertions) {
            IDemoTestAssertions.verifyUIResponse(pizzaInputData, pizzaOutputdata);
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
