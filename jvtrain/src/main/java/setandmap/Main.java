package setandmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Set<String> names = new HashSet<>();
        // Set<Integer> numbers = new HashSet<>(20); // Initial capacity
        // Set<Double> values = new HashSet<>(10, 0.75f); // Capacity, load factor
        // // Adding elements
        // names.add("Alice");
        // names.add("Bob");
        // names.add("Charlie");
        // names.add("Alice"); // Duplicate - ignored
        // System.out.println("Names: " + names);
        // System.out.println("Size: " + names.size());
        // System.out.println("Contains Bob? " + names.contains("Bob"));

        // Set<String> colors = new HashSet<>();
        // colors.add("Red");
        // colors.add("Green");
        // colors.add("Blue");
        // colors.add(null); // HashSet allows one null

        // // Iteration methods
        // System.out.println("\n=== Enhanced for loop ===");
        // for (String color : colors) {
        // System.out.println("Color: " + color);
        // }
        // System.out.println("\n=== Iterator ===");
        // Iterator<String> iterator = colors.iterator();
        // while (iterator.hasNext()) {
        // String color = iterator.next();
        // System.out.println("Color: " + color);
        // // iterator.remove(); // Safe removal
        // }

        // System.out.println("\n=== forEach lambda ===");
        // names.forEach(name -> System.out.println("Name: " + name));

        // Set<String> students = new LinkedHashSet<>();
        // // Adding elements - maintains insertion order
        // students.add("Alice");
        // students.add("Bob");
        // students.add("Charlie");
        // students.add("David");
        // students.add("Alice"); // Duplicate - ignored
        // System.out.println("Students in insertion order: " + students);
        // // Access first element (not directly supported, but we can iterate)
        // String firstStudent = students.iterator().next();
        // System.out.println("First student: " + firstStudent);
        // // Removing elements maintains order of remaining elements
        // students.remove("Bob");
        // System.out.println("After removing Bob: " + students);
        // // Adding new elements adds to the end
        // students.add("Eve");
        // System.out.println("After adding Eve: " + students);
        // // Performance comparison
        // long startTime = System.nanoTime();
        // students.contains("Alice");
        // long endTime = System.nanoTime();
        // System.out.println("Contains check time: " + (endTime - startTime) + " ns");

        // Map<String, String> countryCapitals = new HashMap<>();
        // // 1. Adding key-value pairs
        // countryCapitals.put("USA", "Washington D.C.");
        // countryCapitals.put("UK", "London");
        // countryCapitals.put("France", "Paris");
        // countryCapitals.put("Germany", "Berlin");
        // countryCapitals.put("Japan", "Tokyo");
        // System.out.println("Country Capitals: " + countryCapitals);
        // // 2. Accessing values
        // System.out.println("Capital of France: " + countryCapitals.get("France"));
        // System.out.println("Capital of Italy: " + countryCapitals.get("Italy")); //
        // null
        // // 3. Checking existence
        // System.out.println("Contains USA? " + countryCapitals.containsKey("USA"));
        // System.out.println("Contains Paris? " +
        // countryCapitals.containsValue("Paris"));
        // // 4. Updating values
        // countryCapitals.put("UK", "London, UK"); // Update existing key
        // System.out.println("After update: " + countryCapitals);
        // // 5. Put if absent
        // countryCapitals.putIfAbsent("Italy", "Rome");
        // countryCapitals.putIfAbsent("France", "Marseille"); // Won't update
        // System.out.println("After putIfAbsent: " + countryCapitals);

        // countryCapitals.replace("USA", "New York");
        // System.out.println(countryCapitals);
        // countryCapitals.replace("France", "Paris", "Verdun");
        // System.out.println(countryCapitals);

        Map<String, Integer> studentAges = new HashMap<>();
        studentAges.put("Alice", 20);
        studentAges.put("Bob", 22);
        studentAges.put("Charlie", 19);
        studentAges.put("Diana", 21);
        // 1. Iterate over keys
        System.out.println("=== Keys ===");
        for (String name : studentAges.keySet()) {
            System.out.println("Student: " + name);
        }
        // 2. Iterate over values
        System.out.println("\n=== Values ===");
        for (int age : studentAges.values()) {
            System.out.println("Age: " + age);
        }
        // 3. Iterate over entries (key-value pairs)
        System.out.println("\n=== Entries ===");
        for (Map.Entry<String, Integer> entry : studentAges.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old");
        }
        // 4. forEach with lambda (Java 8+)
        System.out.println("\n=== forEach lambda ===");
        studentAges.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
        studentAges.forEach((name, age) -> System.out.println(name));

    }
}