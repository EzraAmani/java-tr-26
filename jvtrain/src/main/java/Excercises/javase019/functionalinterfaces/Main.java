package Excercises.javase019.functionalinterfaces;

public class Main {
    public static void main(String[] args) {

        // 1. Testing Calculator with lambda expressions
        System.out.println("=== Calculator Tests ===");

        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;

        System.out.println("10 + 5 = " + add.operate(10, 5));
        System.out.println("10 - 5 = " + subtract.operate(10, 5));
        System.out.println("10 * 5 = " + multiply.operate(10, 5));
        System.out.println("10 / 5 = " + divide.operate(10, 5));

        // 2. Testing Validator with lambda expressions
        System.out.println("\n=== Validator Tests ===");

        Validator notEmpty = input -> input != null && !input.trim().isEmpty();
        Validator isEmail = input -> input != null && input.contains("@") && input.contains(".");
        Validator isNumber = input -> {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        System.out.println("'Hello' is not empty: " + notEmpty.validate("Hello"));
        System.out.println("'' is not empty: " + notEmpty.validate(""));
        System.out.println("'test@email.com' is email: " + isEmail.validate("test@email.com"));
        System.out.println("'123' is number: " + isNumber.validate("123"));
        System.out.println("'abc' is number: " + isNumber.validate("abc"));

        // 3. Testing Transformer with lambda expressions
        System.out.println("\n=== Transformer Tests ===");

        Transformer toUpper = input -> input != null ? input.toUpperCase() : "";
        Transformer reverse = input -> input != null ? new StringBuilder(input).reverse().toString() : "";
        Transformer addExclamation = input -> input != null ? input + "!" : "";

        System.out.println("'hello' to uppercase: " + toUpper.transform("hello"));
        System.out.println("'hello' reversed: " + reverse.transform("hello"));
        System.out.println("'hello' with exclamation: " + addExclamation.transform("hello"));

        // 4. Testing Logger with lambda expressions
        System.out.println("\n=== Logger Tests ===");

        Logger consoleLogger = message -> System.out.println("[LOG] " + message);
        Logger errorLogger = message -> System.err.println("[ERROR] " + message);
        Logger timestampLogger = message -> System.out.println(
                "[" + java.time.LocalTime.now() + "] " + message);

        consoleLogger.log("Application started");
        errorLogger.log("Something went wrong");
        timestampLogger.log("This message has timestamp");

        // 5. Combined example - using multiple functional interfaces together
        System.out.println("\n=== Combined Example ===");

        String userInput = "  hello world  ";

        // Create validators
        Validator checkEmpty = input -> input != null && !input.trim().isEmpty();

        // Create transformers
        Transformer trim = input -> input != null ? input.trim() : "";
        Transformer toUpperTransformer = input -> input != null ? input.toUpperCase() : "";

        // Create logger
        Logger processLogger = message -> System.out.println("Processing: " + message);

        // Use them together
        if (checkEmpty.validate(userInput)) {
            String trimmed = trim.transform(userInput);
            String uppercased = toUpperTransformer.transform(trimmed);
            processLogger.log(uppercased);
        }
    }
}