package com.sample.test.demo.tests;

import com.sample.test.demo.com.sample.test.pages.OrderPage;
import com.sample.test.demo.com.sample.test.pages.PizzaData;
import com.sample.test.demo.constants.PizzaPayments;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;

import static com.sample.test.demo.steps.PositiveSteps.BookPizzaWithRandomPizzaInputs;


public class DemoTest extends TestBase {

    @Test
    public void demoTest() {
        System.out.println("HELLO WORLD");

        PizzaData pizzaData = new PizzaData(1, 111111111, "Harry", "abc@amail.com");
        pizzaData
                .setRandomPizzaPayment()
                .setRandomPizzaType()
                .setRandomPizzaTopping1()
                .setRandomPizzaTopping2();

        BookPizzaWithRandomPizzaInputs(driver, pizzaData);
    }

}
