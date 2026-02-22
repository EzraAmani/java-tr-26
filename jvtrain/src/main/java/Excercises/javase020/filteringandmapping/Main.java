package Excercises.javase020.filteringandmapping;

// FilterExample.java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 15, 85),
                new Student("Bob", 16, 92),
                new Student("Charlie", 14, 78),
                new Student("Diana", 17, 95),
                new Student("Eve", 15, 88));

        // Find students: age >= 15 AND grade >= 85
        List<Student> result = students.stream()
                .filter(s -> s.age >= 15)
                .filter(s -> s.grade >= 85)
                .collect(Collectors.toList());

        System.out.println("Top students (15+ years, 85+ grade):");
        result.forEach(System.out::println);

        // MAP example - one-to-one transformation
        List<String> words = Arrays.asList("cat", "dog", "elephant");

        List<Integer> lengths = words.stream()
                .map(word -> word.length())
                .collect(Collectors.toList());

        System.out.println("Words: " + words);
        System.out.println("Word lengths (map): " + lengths);

        // FLATMAP example - one-to-many transformation
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i"));

        List<String> flattened = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("\nList of lists: " + listOfLists);
        System.out.println("Flattened (flatMap): " + flattened);

        List<Product> products = Arrays.asList(
                new Product("Laptop", 999.99, 4),
                new Product("Phone", 699.99, 5),
                new Product("Tablet", 499.99, 4),
                new Product("Watch", 299.99, 3),
                new Product("Headphones", 199.99, 5));

        // Fixed: using getter methods
        List<Product> sorted = products.stream()
                .sorted(Comparator
                        .comparingInt(Product::getRating).reversed()
                        .thenComparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        System.out.println("Products (highest rating, then lowest price):");
        sorted.forEach(System.out::println);

        List<Order> orders = Arrays.asList(
                new Order("Alice", Arrays.asList("book", "pen"), 25.50),
                new Order("Bob", Arrays.asList("laptop", "mouse"), 899.99),
                new Order("Alice", Arrays.asList("notebook"), 12.99),
                new Order("Charlie", Arrays.asList("phone", "case", "charger"), 699.99),
                new Order("Bob", Arrays.asList("headphones"), 89.99));

        // Find all unique items from orders > $100, sorted alphabetically
        List<String> expensiveOrderItems = orders.stream()
                .filter(order -> order.total > 100) // Keep expensive orders
                .peek(order -> System.out.println("Expensive order: " + order))
                .flatMap(order -> order.items.stream()) // Get all items
                .distinct() // Remove duplicates
                .sorted() // Sort alphabetically
                .collect(Collectors.toList());

        System.out.println("\nUnique items from orders over $100:");
        expensiveOrderItems.forEach(item -> System.out.println(" - " + item));

        // Bonus: Find total spent by each customer
        System.out.println("\nTotal spending by customer:");
        Map<String, Double> spending = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.customer,
                        Collectors.summingDouble(order -> order.total)));

        spending.forEach((customer, total) -> System.out.println(customer + ": $" + total));

    }
}