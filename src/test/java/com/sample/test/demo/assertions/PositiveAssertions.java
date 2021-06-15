package com.sample.test.demo.assertions;

import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.constants.PizzaOutputdata;
import org.testng.Assert;


public class PositiveAssertions {

    public static final String SUCCESSFUL_MESSAGE = "Thank you for your order!";
    public static final String COST_TOTAL = "TOTAL:";

    public static void verifyValidOrder(PizzaInputdata pizzaInputData, PizzaOutputdata pizzaOutputdata) {

        // verify SUCCESSFUL_PIZZA COST in Cost TextBox
        Assert.assertEquals(pizzaOutputdata.getTotalCost(), pizzaInputData.getTotalCost(), "pizza cost mismatch in Cost TextBox element");

        // verify SUCCESSFUL_MESSAGE - `Thank you for your order!`
        String[] arr = pizzaOutputdata.getOrderMessage().split(COST_TOTAL);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        String validMessage = arr[0].trim();
        Assert.assertEquals(validMessage, SUCCESSFUL_MESSAGE, "valid order message not found: "+SUCCESSFUL_MESSAGE);

        // verify SUCCESSFUL_PIZZA COST in Dialog
        arr = arr[1].trim().split(" ", 2);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        double dialogTotalCost = Double.parseDouble(arr[0].trim());
        Assert.assertEquals(dialogTotalCost, pizzaInputData.getTotalCost(), "pizza cost mismatch in Post Order Dialog");

        // verify SUCCESSFUL_PIZZA Type in Dialog
        String pizzaType = arr[1].trim();
        Assert.assertEquals(pizzaType, pizzaInputData.getPizzaType().getDisplayName(), "pizza cost mismatch in Post Order Dialog");
    }


}
