package Excercises.javase017.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing Book Sorting ===");
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Animal Farm", "George Orwell"));
        books.add(new Book("1984", "Test Author"));
        books.add(new Book("Brave New World", "Aldous Huxley"));

        Collections.sort(books);
        for (Book b : books)
            System.out.println(b);

        System.out.println("\n=== Testing Product Sorting ===");
        List<Product> products = new ArrayList<>();
        products.add(new Product("Keyboard", "Electronics", 49.99));
        products.add(new Product("Mouse", "Electronics", 19.99));
        products.add(new Product("Notebook", "Stationery", 4.99));
        products.add(new Product("Pen", "Stationery", 1.99));
        products.add(new Product("Pen", "Stationery", 0.99));

        Collections.sort(products);
        for (Product p : products)
            System.out.println(p);

        System.out.println("\n=== Testing Employee Sorting ===");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "Engineering", 75000));
        employees.add(new Employee("Bob", "Engineering", 80000));
        employees.add(new Employee("Charlie", "Marketing", 60000));
        employees.add(new Employee("David", "Marketing", 60000));
        employees.add(new Employee("Eve", "Sales", 55000));

        Collections.sort(employees);
        for (Employee e : employees)
            System.out.println(e);
    }

}
