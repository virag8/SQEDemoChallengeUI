package com.sample.test.demo.framework;

import org.openqa.selenium.WebDriver;

public class CustomTestException extends Exception {
    private static final long serialVersionUID = 7718828512143293558L;


    public CustomTestException(String message, Throwable cause) {
        super(message, cause);
        //TODO custom code followed by exceptions
    }


}