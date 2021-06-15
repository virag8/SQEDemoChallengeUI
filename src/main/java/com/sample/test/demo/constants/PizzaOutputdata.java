package com.sample.test.demo.constants;

import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PizzaOutputdata {
    private String orderMessage;
    private String totalPrice;

    public PizzaOutputdata(String orderMessage, String totalPrice) {
        this.orderMessage = orderMessage;
        this.totalPrice = totalPrice;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public double getTotalCost() {
        return Double.parseDouble(totalPrice);
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
