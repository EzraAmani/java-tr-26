package Excercises.javase006;

public class StringProcessor {

    // Convert a string to uppercase
    public static String toUpperCase(String text) {
        return text.toUpperCase();
    }

    // Convert a string to lowercase
    public static String toLowerCase(String text) {
        return text.toLowerCase();
    }

    // Count the number of words in a string
    public static int wordCount(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Capitalize the first letter of each word

}