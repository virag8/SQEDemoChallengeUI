package com.sample.test.demo.assertions;

import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.constants.PizzaOutputdata;
import org.testng.Assert;

public class DemoTestAssertions {

    public static final String SUCCESSFUL_MESSAGE = "Thank you for your order!";
    public static final String COST_TOTAL = "TOTAL:";

    public static IDemoTestAssertions assertionSuccessfulOrderMessage = (pizzaInputData, pizzaOutputs) -> {
        // verify SUCCESSFUL_MESSAGE - `Thank you for your order!`
        String[] arr = pizzaOutputs.getOrderMessage().split(COST_TOTAL);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        String validMessage = arr[0].trim();
        Assert.assertEquals(validMessage, SUCCESSFUL_MESSAGE, "valid order message not found: " + SUCCESSFUL_MESSAGE);
    };

    public static IDemoTestAssertions assertionPizzaCostInTextBox = (pizzaInputData, pizzaOutputs) -> {
        // verify SUCCESSFUL_PIZZA COST in Cost TextBox
        Assert.assertEquals(pizzaOutputs.getTotalCost(), pizzaInputData.getTotalCost(), "pizza cost mismatch in Cost TextBox element");
    };

    public static IDemoTestAssertions assertionPizzaCostInDialog = (pizzaInputData, pizzaOutputs) -> {
        String[] arr = pizzaOutputs.getOrderMessage().split(COST_TOTAL);
        // verify SUCCESSFUL_PIZZA COST in Dialog
        arr = arr[1].trim().split(" ", 2);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        double dialogTotalCost = Double.parseDouble(arr[0].trim());
        Assert.assertEquals(dialogTotalCost, pizzaInputData.getTotalCost(), "pizza cost mismatch in Post Order Dialog");
    };

    /**/
    public static IDemoTestAssertions assertionPizzaTypeInDialog = (pizzaInputData, pizzaOutputs) -> {
        String[] arr = pizzaOutputs.getOrderMessage().split(COST_TOTAL);
        arr = arr[1].trim().split(" ", 2);
        // verify SUCCESSFUL_PIZZA Type in Dialog
        String pizzaType = arr[1].trim();
        Assert.assertEquals(pizzaType, pizzaInputData.getPizzaType().getDisplayName(), "pizza cost mismatch in Post Order Dialog");
    };

    public static IDemoTestAssertions demoTestPositiveAssertions = (pizzaInputData, pizzaOutputs) -> {
        // verify SUCCESSFUL_PIZZA COST in Cost TextBox
        Assert.assertEquals(pizzaOutputs.getTotalCost(), pizzaInputData.getTotalCost(), "pizza cost mismatch in Cost TextBox element");

        // verify SUCCESSFUL_MESSAGE - `Thank you for your order!`
        String[] arr = pizzaOutputs.getOrderMessage().split(COST_TOTAL);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        String validMessage = arr[0].trim();
        Assert.assertEquals(validMessage, SUCCESSFUL_MESSAGE, "valid order message not found: " + SUCCESSFUL_MESSAGE);

        // verify SUCCESSFUL_PIZZA COST in Dialog
        arr = arr[1].trim().split(" ", 2);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        double dialogTotalCost = Double.parseDouble(arr[0].trim());
        Assert.assertEquals(dialogTotalCost, pizzaInputData.getTotalCost(), "pizza cost mismatch in Post Order Dialog");

        // verify SUCCESSFUL_PIZZA Type in Dialog
        String pizzaType = arr[1].trim();
        Assert.assertEquals(pizzaType, pizzaInputData.getPizzaType().getDisplayName(), "pizza cost mismatch in Post Order Dialog");
    };

    public static IDemoTestAssertions assertionInvalidPizzaCostInTextBox = (pizzaInputData, pizzaOutputs) -> {
        // verify SUCCESSFUL_PIZZA COST in Cost TextBox
        Assert.assertTrue(pizzaOutputs.getTotalCost() == 0 || String.valueOf(pizzaOutputs.getTotalCost()) == "NaN", "pizza cost not equal to 0 or NaN in Cost TextBox element");

        // verify SUCCESSFUL_MESSAGE - `Thank you for your order! is not present`
        String[] arr = pizzaOutputs.getOrderMessage().split(COST_TOTAL);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        String validMessage = arr[0].trim();
        Assert.assertNotEquals(validMessage, SUCCESSFUL_MESSAGE, "valid order message should not be present: " + SUCCESSFUL_MESSAGE);
    };

    public static IDemoTestAssertions assertionInvalidSuccessInDialog = (pizzaInputData, pizzaOutputs) -> {
        // verify SUCCESSFUL_MESSAGE - `Thank you for your order! is not present`
        String[] arr = pizzaOutputs.getOrderMessage().split(COST_TOTAL);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        String validMessage = arr[0].trim();
        Assert.assertNotEquals(validMessage, SUCCESSFUL_MESSAGE, "valid order message should not be present: " + SUCCESSFUL_MESSAGE);
    };


}
