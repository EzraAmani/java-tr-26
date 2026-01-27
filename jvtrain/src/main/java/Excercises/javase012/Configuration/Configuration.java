package Excercises.javase012.Configuration;

public class Configuration {
    public static final String APP_NAME;
    public static final int MAX_USERS;
    public static final double VERSION;
    public static final boolean DEBUG_MODE;

    static {
        APP_NAME = "MyApp";
        MAX_USERS = 100;
        VERSION = 1.5;
        DEBUG_MODE = true;

        System.out.println("Configuration loaded");
    }

    public static void printConfig() {
        System.out.println("App: " + APP_NAME);
        System.out.println("Max Users: " + MAX_USERS);
        System.out.println("Version: " + VERSION);
        System.out.println("Debug: " + DEBUG_MODE);
    }
}
