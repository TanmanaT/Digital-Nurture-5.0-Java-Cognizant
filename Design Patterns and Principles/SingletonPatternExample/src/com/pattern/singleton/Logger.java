package com.pattern.singleton;

public class Logger {
    // Private static instance of the same class
    private static Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Initialization code if needed
    }

    // Public static method to provide global access point
    // Using double-checked locking for thread-safe lazy initialization
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // A simple log message method to verify functionality
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
