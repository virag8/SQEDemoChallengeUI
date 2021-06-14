package com.sample.test.demo.com.sample.test.pages;

import com.sample.test.demo.constants.PizzaPayments;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

import java.util.Random;

public class PizzaData {
    private int quantity, phone;
    private String name, email;
    private PizzaTypes pizzaType;
    private PizzaToppings toppings1, toppings2;
    private PizzaPayments paymentType;

    public PizzaData() {

    }

    public PizzaData(int quantity, int phone, String name, String email) {
        this.quantity = quantity;
        this.phone = phone;
        this.name = name;
        this.email = email;
    }

    public PizzaData(int quantity, int phone, String name, String email, PizzaTypes pizzaType, PizzaToppings toppings1, PizzaToppings toppings2, PizzaPayments paymentType) {
        this.quantity = quantity;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.pizzaType = pizzaType;
        this.toppings1 = toppings1;
        this.toppings2 = toppings2;
        this.paymentType = paymentType;
    }

    public int getQuantity() {
        return quantity;
    }

    public PizzaData setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public PizzaData setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public PizzaData setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PizzaData setEmail(String email) {
        this.email = email;
        return this;
    }

    public PizzaTypes getPizzaType() {
        return pizzaType;
    }

    public PizzaData setPizzaType(PizzaTypes pizzaType) {
        this.pizzaType = pizzaType;
        return this;
    }

    public PizzaToppings getToppings1() {
        return this.toppings1;
    }

    public PizzaData setToppings1(PizzaToppings toppings1) {
        this.toppings1 = toppings1;
        return this;
    }

    public PizzaToppings getToppings2() {
        return this.toppings2;
    }

    public PizzaData setToppings2(PizzaToppings toppings2) {
        this.toppings2 = toppings2;
        return this;
    }

    public PizzaPayments getPaymentType() {
        return this.paymentType;
    }

    public PizzaData setCash(PizzaPayments paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PizzaData setRandomPizzaPayment() {
        this.paymentType = PizzaPayments.values()[new Random().nextInt(PizzaPayments.values().length)];
        return this;
    }

    public PizzaData setRandomPizzaType() {
        this.pizzaType = PizzaTypes.values()[new Random().nextInt(PizzaTypes.values().length)];
        return this;
    }

    public PizzaData setRandomPizzaTopping1() {
        this.toppings1 = PizzaToppings.values()[new Random().nextInt(PizzaToppings.values().length)];
        return this;
    }

    public PizzaData setRandomPizzaTopping2() {
        this.toppings2 = PizzaToppings.values()[new Random().nextInt(PizzaToppings.values().length)];
        return this;
    }

    public double getTotalCost() {
        return this.pizzaType.getCost() * this.quantity;
    }
}
