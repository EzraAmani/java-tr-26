package Excercises.javase012.Configuration;

public class Main {
    public static void main(String[] args) {
        // Access constants directly
        System.out.println(Configuration.APP_NAME);
        System.out.println(Configuration.MAX_USERS);

        // Use static method
        Configuration.printConfig();
    }
}
