package com.pattern.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        // Retrieve two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using both instances
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Check if both references point to the exact same instance
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both logger1 and logger2 point to the same instance.");
        } else {
            System.out.println("FAILURE: logger1 and logger2 point to different instances.");
        }
    }
}
