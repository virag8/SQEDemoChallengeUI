package com.sample.test.demo.constants;


public enum PizzaPayments {
    CREDIT_CARD("Credit Card"),
    CASH_ON_PICKUP("Cash on Pickup"),
    ;

    private String displayName;

    private PizzaPayments(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}