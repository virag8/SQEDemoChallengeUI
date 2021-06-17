package com.sample.test.demo.steps;

import com.sample.test.demo.com.sample.test.pages.OrderPage;
import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.framework.Log;
import org.openqa.selenium.WebDriver;

public class DemoSteps {
    OrderPage orderPage;

    public DemoSteps(WebDriver driver) {
        driver.navigate().refresh();
        orderPage = new OrderPage(driver);
    }


    public String fillPizzaInputs(PizzaInputdata pizzaInputData) {
        Log.debug(String.format("%s", pizzaInputData.toString()));

        orderPage
                .choosePizza(pizzaInputData.getPizzaType(), pizzaInputData.getToppings1(), pizzaInputData.getToppings2())
                .chooseQuantity(pizzaInputData.getQuantity())
                .providePersonalDetails(pizzaInputData.getName(), pizzaInputData.getEmail(), pizzaInputData.getPhone())
                .choosePayment(pizzaInputData.getPaymentType());

        Log.debug(String.format("GetPizzaCost: %s", orderPage.getPizzaCost()));

        return orderPage.getPizzaCost();
    }

    public void confirmOrder() {
        orderPage.confirmOrder();
    }

    public String fetchPostOrderDialog() {
        String orderMessage = orderPage.getPostOrderMessage();
        Log.debug(String.format("PostOrderMessage: %s", orderMessage));

        return orderMessage;
    }

    public void closeDialog() {
        orderPage.closePostOrderMessage();
    }
}


