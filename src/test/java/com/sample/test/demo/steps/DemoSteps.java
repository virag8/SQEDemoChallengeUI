package com.sample.test.demo.steps;

import com.sample.test.demo.com.sample.test.pages.OrderPage;
import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.constants.PizzaOutputdata;
import com.sample.test.demo.framework.Log;
import org.openqa.selenium.WebDriver;

public class DemoSteps {
    OrderPage orderPage;

    public DemoSteps(WebDriver driver) {
        orderPage = new OrderPage(driver);
    }


    public String FillPizzaInputs(PizzaInputdata pizzaInputData) {
        Log.debug(String.format("%s", pizzaInputData.toString()));

        orderPage
                .ChoosePizza(pizzaInputData.getPizzaType(), pizzaInputData.getToppings1(), pizzaInputData.getToppings2())
                .ChooseQuantity(pizzaInputData.getQuantity())
                .ProvidePersonalDetails(pizzaInputData.getName(), pizzaInputData.getEmail(), pizzaInputData.getPhone())
                .ChoosePayment(pizzaInputData.getPaymentType());

        Log.debug(String.format("GetPizzaCost: %s", orderPage.GetPizzaCost()));

        return orderPage.GetPizzaCost();
    }

    public String ConfirmOrder() {
        orderPage.ConfirmOrder();

        return null;
    }

    public String ConfirmOrder(boolean closePostOrderMessage) {
        ConfirmOrder();

        String orderMessage = orderPage.GetPostOrderMessage();
        if (closePostOrderMessage) {
            orderPage.ClosePostOrderMessage();
        }
        Log.debug(String.format("PostOrderMessage: %s", orderMessage));

        return orderMessage;
    }

    public void CloseDialog() {
        orderPage.ClosePostOrderMessage();
    }
}


