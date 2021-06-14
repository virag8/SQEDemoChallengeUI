package com.sample.test.demo.steps;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.com.sample.test.pages.OrderPage;
import com.sample.test.demo.com.sample.test.pages.PizzaData;
import org.openqa.selenium.WebDriver;

public class PositiveSteps extends TestBase {

    public static void BookPizzaWithRandomPizzaInputs(WebDriver driver, PizzaData pizzaData) {
        OrderPage orderPage = new OrderPage(driver);

        orderPage
                .ChoosePizza(pizzaData.getPizzaType(), pizzaData.getToppings1(), pizzaData.getToppings2())
                .ChooseQuantity(pizzaData.getQuantity())
                .ProvidePersonalDetails(pizzaData.getName(), pizzaData.getEmail(), pizzaData.getPhone())
                .ChoosePayment(pizzaData.getPaymentType());

        System.out.println(orderPage.GetPizzaCost());

        orderPage.ConfirmOrder();
        System.out.println(orderPage.GetPostOrderMessage());
        orderPage.ClosePostOrderMessage();




        //Assertions
    }
}
