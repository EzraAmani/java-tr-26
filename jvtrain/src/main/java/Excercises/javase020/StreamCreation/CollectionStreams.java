package Excercises.javase020.StreamCreation;

import java.util.*;
import java.util.stream.*;

class CollectionStreams {

    public static void demonstrate() {
        System.out.println("=== STREAMS FROM COLLECTIONS ===\n");

        // 1. From List
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("From List:");
        fruits.stream().forEach(f -> System.out.println("  " + f));

        // 2. From Set
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("\nFrom Set:");
        numbers.stream().forEach(n -> System.out.println("  " + n));

        // 3. From Array
        String[] colors = { "Red", "Green", "Blue" };
        System.out.println("\nFrom Array:");
        Arrays.stream(colors).forEach(c -> System.out.println("  " + c));

        // 4. From Map
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);

        System.out.println("\nFrom Map (keys):");
        ages.keySet().stream().forEach(k -> System.out.println("  " + k));

        System.out.println("\nFrom Map (values):");
        ages.values().stream().forEach(v -> System.out.println("  " + v));

        System.out.println("\nFrom Map (entries):");
        ages.entrySet().stream().forEach(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));
    }
}
