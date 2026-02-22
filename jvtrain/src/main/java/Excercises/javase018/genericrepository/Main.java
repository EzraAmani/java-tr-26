package Excercises.javase018.genericrepository;

// RepositoryDemo.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generic Repository System Demo ===\n");

        // Student Repository Demo
        System.out.println("--- Student Repository ---");
        Repository<Student> studentRepo = new InMemoryRepository<>();

        // Save students
        Student student1 = studentRepo.save(new Student("Alice", "A"));
        Student student2 = studentRepo.save(new Student("Bob", "B"));
        Student student3 = studentRepo.save(new Student("Charlie", "A"));

        System.out.println("Saved students:");
        studentRepo.findAll().forEach(System.out::println);

        // Find by ID
        System.out.println("\nFinding student with ID 2:");
        studentRepo.findById(2).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Student not found"));

        // Update student
        System.out.println("\nUpdating student Bob to grade A:");
        Student updatedStudent = new Student("Bob Updated", "A");
        updatedStudent.setId(2);
        studentRepo.update(updatedStudent);
        System.out.println(studentRepo.findById(2).orElse(null));

        // Count
        System.out.println("\nTotal students: " + studentRepo.count());

        // Product Repository Demo
        System.out.println("\n--- Product Repository ---");
        Repository<Product> productRepo = new InMemoryRepository<>();

        // Save products
        Product product1 = productRepo.save(new Product("Laptop", 999.99));
        Product product2 = productRepo.save(new Product("Mouse", 29.99));
        Product product3 = productRepo.save(new Product("Keyboard", 79.99));

        System.out.println("Saved products:");
        productRepo.findAll().forEach(System.out::println);

        // Find by ID
        System.out.println("\nFinding product with ID 1:");
        productRepo.findById(1).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Product not found"));

        // Delete product
        System.out.println("\nDeleting product with ID 3:");
        productRepo.delete(3);
        System.out.println("Product exists? " + productRepo.exists(3));
        System.out.println("Remaining products:");
        productRepo.findAll().forEach(System.out::println);

        // Demonstrate count
        System.out.println("\nTotal products: " + productRepo.count());
    }
}