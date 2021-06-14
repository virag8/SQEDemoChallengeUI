package com.sample.test.demo.com.sample.test.pages;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaPayments;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.util.Strings;

public class OrderPage extends TestBase {


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
    }

    public String GetPizzaCost() {
        return Strings.isNullOrEmpty(tbPizzaCost.getText()) ? tbPizzaCost.getAttribute("value") : tbPizzaCost.getText();
    }

    public OrderPage ChoosePayment(PizzaPayments paymentType) {
        if (paymentType.equals(PizzaPayments.CASH_ON_PICKUP)) {
            rbCashPayment.click();
        } else if (paymentType.equals(PizzaPayments.CREDIT_CARD)) {
            rbCCPayment.click();
        }
        return this;
    }

    public OrderPage ConfirmOrder() {
        btnPlaceOrder.click();
        return this;
    }

    public OrderPage ChooseQuantity(int quantity) {
        tbPizzaQty.clear();
        tbPizzaQty.sendKeys(String.valueOf(quantity));
        return this;
    }


    public OrderPage ProvidePersonalDetails(String Name, String Email, int Phone) {
        tbName.sendKeys(Name);
        tbEmail.sendKeys(Email);
        tbPhone.sendKeys(String.valueOf(Phone));
        return this;
    }

    public OrderPage ChoosePizza(PizzaTypes PizzaType, PizzaToppings Toppings1, PizzaToppings Toppings2) {
        super.DropDown(dropPizza).selectByValue(PizzaType.getDisplayName());
        super.DropDown(dropToppings1).selectByValue(Toppings1.getDisplayName());
        super.DropDown(dropToppings2).selectByValue(Toppings2.getDisplayName());
        return this;
    }

    public String GetPostOrderMessage() {
        return Strings.isNullOrEmpty(dialogPostOrder.getText()) ? dialogPostOrder.getAttribute("value") : dialogPostOrder.getText();
    }

    public OrderPage ClosePostOrderMessage() {
        btnCloseDialog.click();
        return this;
    }
}
