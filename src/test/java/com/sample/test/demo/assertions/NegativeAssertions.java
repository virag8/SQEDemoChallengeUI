package com.sample.test.demo.assertions;

import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.constants.PizzaOutputdata;
import org.testng.Assert;


public class NegativeAssertions {

    public static final String SUCCESSFUL_MESSAGE = "Thank you for your order!";
    public static final String COST_TOTAL = "TOTAL:";

    public static void verifyInvalidIntegerQuantity(PizzaInputdata pizzaInputData, PizzaOutputdata pizzaOutputdata) {
        // verify SUCCESSFUL_PIZZA COST in Cost TextBox
        Assert.assertTrue(pizzaOutputdata.getTotalCost() == 0 || String.valueOf(pizzaOutputdata.getTotalCost()) == "NaN", "pizza cost not equal to 0 or NaN in Cost TextBox element");

        // verify SUCCESSFUL_MESSAGE - `Thank you for your order! is not present`
        String[] arr = pizzaOutputdata.getOrderMessage().split(COST_TOTAL);
        Assert.assertEquals(arr.length, 2, "valid order message formatting issue");
        String validMessage = arr[0].trim();
        Assert.assertNotEquals(validMessage, SUCCESSFUL_MESSAGE, "valid order message should not be present: " + SUCCESSFUL_MESSAGE);
    }


}
