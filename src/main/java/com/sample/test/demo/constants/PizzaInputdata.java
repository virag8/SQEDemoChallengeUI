package com.sample.test.demo.constants;

import com.sample.test.demo.utils.Randoms;
import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Random;

public class PizzaInputdata {
    private String name, quantity, email, phone;
    private PizzaTypes pizzaType;
    private PizzaToppings toppings1, toppings2;
    private PizzaPayments paymentType;

    public PizzaInputdata() {

    }

    public PizzaInputdata(String phone, String name, String email) {
        this.phone = phone;
        this.name = name;
        this.email = email;
    }

    public PizzaInputdata(String quantity, String phone, String name, String email, PizzaTypes pizzaType, PizzaToppings toppings1, PizzaToppings toppings2, PizzaPayments paymentType) {
        this.quantity = quantity;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.pizzaType = pizzaType;
        this.toppings1 = toppings1;
        this.toppings2 = toppings2;
        this.paymentType = paymentType;
    }

    public String getQuantity() {
        return quantity;
    }

    public PizzaInputdata setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PizzaInputdata setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public PizzaInputdata setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PizzaInputdata setEmail(String email) {
        this.email = email;
        return this;
    }

    public PizzaTypes getPizzaType() {
        return pizzaType;
    }

    public PizzaInputdata setPizzaType(PizzaTypes pizzaType) {
        this.pizzaType = pizzaType;
        return this;
    }

    public PizzaToppings getToppings1() {
        return this.toppings1;
    }

    public PizzaInputdata setToppings1(PizzaToppings toppings1) {
        this.toppings1 = toppings1;
        return this;
    }

    public PizzaToppings getToppings2() {
        return this.toppings2;
    }

    public PizzaInputdata setToppings2(PizzaToppings toppings2) {
        this.toppings2 = toppings2;
        return this;
    }

    public PizzaPayments getPaymentType() {
        return this.paymentType;
    }

    public PizzaInputdata setCash(PizzaPayments paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public PizzaInputdata setRandomQuantity() {
        this.quantity = String.valueOf(Randoms.getRandomNumber(1, 100));
        return this;
    }

    public PizzaInputdata setRandomPizzaPayment() {
        this.paymentType = PizzaPayments.values()[new Random().nextInt(PizzaPayments.values().length)];
        return this;
    }

    public PizzaInputdata setRandomPizzaType() {
        this.pizzaType = PizzaTypes.values()[new Random().nextInt(PizzaTypes.values().length)];
        return this;
    }

    public PizzaInputdata setRandomUniquePizzaToppings() {
        int index1 = Randoms.getRandomNumber(PizzaToppings.values().length),
                index2 = Randoms.getRandomNumber(PizzaToppings.values().length);

        //Choose unique toppings
        while (index1 == index2) {
            index1 = Randoms.getRandomNumber(PizzaToppings.values().length);
        }
        this.toppings1 = PizzaToppings.values()[index1];
        this.toppings2 = PizzaToppings.values()[index2];
        return this;
    }

    public PizzaInputdata setRandomPizzaTopping1() {
        this.toppings1 = PizzaToppings.values()[Randoms.getRandomNumber(PizzaToppings.values().length)];
        return this;
    }

    public PizzaInputdata setRandomPizzaTopping2() {
        this.toppings2 = PizzaToppings.values()[Randoms.getRandomNumber(PizzaToppings.values().length)];
        return this;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public double getTotalCost() {
        return this.pizzaType.getCost() * Integer.valueOf(this.quantity);
    }
}
