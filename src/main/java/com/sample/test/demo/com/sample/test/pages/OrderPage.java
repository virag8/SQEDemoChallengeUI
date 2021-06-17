package com.sample.test.demo.com.sample.test.pages;

import com.sample.test.demo.framework.SeleniumBase;
import com.sample.test.demo.constants.PizzaPayments;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.util.Strings;

public class OrderPage {

    private SeleniumBase seleniumBase;

    @FindBy(id = "placeOrder")
    WebElement btnPlaceOrder;

    @FindBy(id = "reset")
    WebElement btnReset;

    @FindBy(id = "pizza1Pizza")
    WebElement dropPizza;

    @FindBy(className = "toppings1")
    WebElement dropToppings1;

    @FindBy(className = "toppings2")
    WebElement dropToppings2;

    @FindBy(id = "pizza1Qty")
    WebElement tbPizzaQty;

    @FindBy(id = "pizza1Cost")
    WebElement tbPizzaCost;

    @FindBy(id = "name")
    WebElement tbName;

    @FindBy(id = "email")
    WebElement tbEmail;

    @FindBy(id = "phone")
    WebElement tbPhone;

    @FindBy(id = "ccpayment")
    WebElement rbCCPayment;

    @FindBy(id = "cashpayment")
    WebElement rbCashPayment;

    @FindBy(id = "dialog")
    WebElement dialogPostOrder;

    @FindBy(xpath = "//*[@title='Close']")
    WebElement btnCloseDialog;

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        seleniumBase = new SeleniumBase(driver);
    }

    public String getPizzaCost() {
        Assert.assertNotNull(seleniumBase.getElementAttribute(tbPizzaCost, "readonly"), "pizza cost textbox is not readonly");
        return Strings.isNullOrEmpty(tbPizzaCost.getText()) ? tbPizzaCost.getAttribute("value") : tbPizzaCost.getText();
    }

    public OrderPage choosePayment(PizzaPayments paymentType) {
        if (paymentType.equals(PizzaPayments.CASH_ON_PICKUP)) {
            rbCashPayment.click();
        } else if (paymentType.equals(PizzaPayments.CREDIT_CARD)) {
            rbCCPayment.click();
        }
        return this;
    }

    public OrderPage confirmOrder() {
        btnPlaceOrder.click();
        return this;
    }

    public OrderPage chooseQuantity(String quantity) {
        tbPizzaQty.clear();
        tbPizzaQty.sendKeys(quantity);
        return this;
    }

    public OrderPage providePersonalDetails(String name, String email, String phone) {
        tbName.sendKeys(name);
        tbEmail.sendKeys(email);
        tbPhone.sendKeys(phone);
        return this;
    }

    public OrderPage choosePizza(PizzaTypes pizzaType, PizzaToppings toppings1, PizzaToppings toppings2) {
        seleniumBase.dropDown(dropPizza).selectByValue(pizzaType.getDisplayName());
        seleniumBase.dropDown(dropToppings1).selectByValue(toppings1.getDisplayName());
        seleniumBase.dropDown(dropToppings2).selectByValue(toppings2.getDisplayName());
        return this;
    }

    public String getPostOrderMessage() {
        return Strings.isNullOrEmpty(dialogPostOrder.getText()) ? dialogPostOrder.getAttribute("value") : dialogPostOrder.getText();
    }

    public OrderPage closePostOrderMessage() {
        btnCloseDialog.click();
        return this;
    }
}
