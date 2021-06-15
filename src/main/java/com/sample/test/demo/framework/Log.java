package com.sample.test.demo.framework;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class Log {
    private static Logger Log = Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        Log.info(message);
        Reporter.log(message);
    }

    public static void error(String message) {
        Log.error(message);
        Reporter.log(message);
    }

    public static void debug(String message) {
        Log.debug(message);
        Reporter.log(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
        Reporter.log(message);
    }
}
