package Excercises.javase016.Wordcounter;

import java.util.*;

public class wordcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        // Clean the text
        String cleanText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        // Split into words
        String[] words = cleanText.split("\\s+");

        // Use HashSet to remove duplicates
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                hashSet.add(word);
                linkedHashSet.add(word);
            }
        }

        // Display results
        System.out.println("\n=== Results ===");
        System.out.println("Total words found: " + words.length);
        System.out.println("Unique words: " + hashSet.size());

        System.out.println("\nHashSet (no order): " + hashSet);
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        scanner.close();
    }
}