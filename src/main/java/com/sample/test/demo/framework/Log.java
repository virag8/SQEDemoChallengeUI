package com.sample.test.demo.framework;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public final class Log {
    private static Logger logger = Logger.getLogger(Log.class.getName());

    private Log() {
    }

    public static void info(String message) {
        logger.info(message);
        Reporter.log(message);
    }

    public static void error(String message) {
        logger.error(message);
        Reporter.log(message);
    }

    public static void debug(String message) {
        logger.debug(message);
        Reporter.log(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
        Reporter.log(message);
    }
}
