package Excercises.javase017.collectionfilter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== FILTER EVEN NUMBERS ===");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original: " + numbers);

        List<Integer> oddNumbers = CollectionFilter.filterEvenNumbers(numbers);
        System.out.println("After removing evens: " + oddNumbers);

        System.out.println("\n=== FILTER SHORT STRINGS ===");
        List<String> words = new ArrayList<>(Arrays.asList("cat", "a", "dog", "hi", "elephant", "to", "bird"));
        System.out.println("Original: " + words);

        List<String> longWords = CollectionFilter.filterShortStrings(words);
        System.out.println("After removing length<3: " + longWords);

        System.out.println("\n=== FILTER LOW GRADES ===");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "A"));
        students.add(new Student("Bob", "C"));
        students.add(new Student("Charlie", "F"));
        students.add(new Student("David", "B"));
        students.add(new Student("Eve", "D"));
        System.out.println("Original: " + students);

        List<Student> goodStudents = CollectionFilter.filterLowGrades(students);
        System.out.println("After removing D/F: " + goodStudents);

        System.out.println("\n=== USING GENERIC FILTER ===");
        // Filter numbers > 5
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 5, 8, 3, 10, 1));
        List<Integer> filtered = CollectionFilter.filter(nums, new CollectionFilter.FilterCondition<Integer>() {
            public boolean shouldRemove(Integer n) {
                return n > 5;
            }
        });
        System.out.println("Numbers >5 removed: " + filtered);

        // Filter words starting with 'a'
        List<String> filteredWords = CollectionFilter.filter(words,
                item -> item.startsWith("a") // Lambda version
        );
        System.out.println("Words starting with 'a' removed: " + filteredWords);
    }
}