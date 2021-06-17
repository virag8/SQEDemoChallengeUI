package com.sample.test.demo.framework;

public class CustomTestException extends Exception {
    private static final long serialVersionUID = 7718828512143293558L;


    public CustomTestException(String message, Throwable cause) {
        super(message, cause);
        Log.error(message + ": " + cause.toString());
    }


}
