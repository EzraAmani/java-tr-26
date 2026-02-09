package Excercises.javase017.comparable2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ===== 1. EMPLOYEE SORTING =====
        System.out.println("=== Employees: Salary (desc), then Name (asc) ===");
        List<Employee2> employees = Arrays.asList(
                new Employee2("Alice", 75000),
                new Employee2("Bob", 80000),
                new Employee2("Charlie", 80000),
                new Employee2("David", 70000),
                new Employee2("Eve", 75000));

        // Traditional approach (pre-Java 8)
        Comparator<Employee2> traditionalEmpComparator = new Comparator<Employee2>() {
            @Override
            public int compare(Employee2 e1, Employee2 e2) {
                // Salary descending
                int salaryCompare = Double.compare(e2.salary, e1.salary);
                if (salaryCompare != 0)
                    return salaryCompare;
                // Name ascending
                return e1.name.compareTo(e2.name);
            }
        };

        // Modern approach (Java 8+) - using getter method references
        Comparator<Employee2> modernEmpComparator = Comparator
                .comparingDouble(Employee2::getSalary).reversed()
                .thenComparing(Employee2::getName);

        // Sort using traditional comparator
        List<Employee2> employeesCopy1 = new ArrayList<>(employees);
        employeesCopy1.sort(traditionalEmpComparator);
        System.out.println("Traditional: " + employeesCopy1);

        // Sort using modern comparator
        List<Employee2> employeesCopy2 = new ArrayList<>(employees);
        employeesCopy2.sort(modernEmpComparator);
        System.out.println("Modern:     " + employeesCopy2);

        // ===== 2. PRODUCT SORTING =====
        System.out.println("\n=== Products: Price Category, then Rating ===");
        List<Product2> products = Arrays.asList(
                new Product2("Mouse", "budget", 4.2),
                new Product2("Keyboard", "premium", 4.8),
                new Product2("Monitor", "standard", 4.5),
                new Product2("Headphones", "budget", 4.7),
                new Product2("Laptop", "premium", 4.3));

        // Define category order
        Map<String, Integer> categoryOrder = Map.of(
                "budget", 1,
                "standard", 2,
                "premium", 3);

        // Traditional approach
        Comparator<Product2> traditionalProdComparator = new Comparator<Product2>() {
            @Override
            public int compare(Product2 p1, Product2 p2) {
                // Price category (budget < standard < premium)
                int categoryCompare = Integer.compare(
                        categoryOrder.get(p1.priceCategory),
                        categoryOrder.get(p2.priceCategory));
                if (categoryCompare != 0)
                    return categoryCompare;
                // Rating descending
                return Double.compare(p2.rating, p1.rating);
            }
        };

        // Modern approach - using lambda instead of method reference for custom
        // ordering
        Comparator<Product2> modernProdComparator = Comparator
                .comparingInt((Product2 p) -> categoryOrder.get(p.getPriceCategory()))
                .thenComparingDouble(Product2::getRating).reversed();

        // Sort using traditional comparator
        List<Product2> productsCopy1 = new ArrayList<>(products);
        productsCopy1.sort(traditionalProdComparator);
        System.out.println("Traditional: " + productsCopy1);

        // Sort using modern comparator
        List<Product2> productsCopy2 = new ArrayList<>(products);
        productsCopy2.sort(modernProdComparator);
        System.out.println("Modern:     " + productsCopy2);

        // ===== 3. BOOK SORTING =====
        System.out.println("\n=== Books: Year (newest first), then Title ===");
        List<Book2> books = Arrays.asList(
                new Book2("1984", 1949),
                new Book2("Brave New World", 1932),
                new Book2("Fahrenheit 451", 1953),
                new Book2("Animal Farm", 1945),
                new Book2("1984", 2023) // New edition
        );

        // Traditional approach
        Comparator<Book2> traditionalBookComparator = new Comparator<Book2>() {
            @Override
            public int compare(Book2 b1, Book2 b2) {
                // Year descending (newest first)
                int yearCompare = Integer.compare(b2.year, b1.year);
                if (yearCompare != 0)
                    return yearCompare;
                // Title ascending
                return b1.title.compareTo(b2.title);
            }
        };

        // Modern approach - using getter method references
        Comparator<Book2> modernBookComparator = Comparator
                .comparingInt(Book2::getYear).reversed()
                .thenComparing(Book2::getTitle);

        // Sort using traditional comparator
        List<Book2> booksCopy1 = new ArrayList<>(books);
        booksCopy1.sort(traditionalBookComparator);
        System.out.println("Traditional: " + booksCopy1);

        // Sort using modern comparator
        List<Book2> booksCopy2 = new ArrayList<>(books);
        booksCopy2.sort(modernBookComparator);
        System.out.println("Modern:     " + booksCopy2);
    }

}
