package Excercises.javase016.Wordfrequencycounter;

import java.util.*;

public class WordFrequencyWithInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input
        System.out.println("Enter a sentence:");
        String text = scanner.nextLine();

        // Clean and split
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        String[] words = text.split("\\s+");

        // Count frequencies
        HashMap<String, Integer> frequencies = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Shorter way using getOrDefault
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }

        // Display in alphabetical order
        System.out.println("\n=== WORD FREQUENCIES (A to Z) ===");
        ArrayList<String> sortedWords = new ArrayList<>(frequencies.keySet());
        Collections.sort(sortedWords);

        for (String word : sortedWords) {
            System.out.println("  " + word + ": " + frequencies.get(word));
        }

        // Find most frequent
        int maxCount = 0;
        for (int count : frequencies.values()) {
            if (count > maxCount)
                maxCount = count;
        }

        System.out.println("\n=== MOST FREQUENT (appears " + maxCount + " times) ===");
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println("  " + entry.getKey());
            }
        }

        System.out.println(words);

        scanner.close();
    }
}