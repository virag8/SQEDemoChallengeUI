package com.sample.test.demo.assertions;

import com.sample.test.demo.constants.PizzaInputdata;
import com.sample.test.demo.constants.PizzaOutputdata;

@FunctionalInterface
public interface IDemoTestAssertions {
    void verifyUIResponse(PizzaInputdata pizzaInputData, PizzaOutputdata pizzaOutputdata);
}
