package Excercises.javase016.Studentdb;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        System.out.println("=== ADDING STUDENTS ===");
        // Add students
        db.addStudent(new Student(101, "Alice", "alice@email.com"));
        db.addStudent(new Student(102, "Bob", "bob@email.com"));
        db.addStudent(new Student(103, "Charlie", "charlie@email.com"));

        System.out.println();

        // Try to add duplicate ID
        System.out.println("=== TRYING DUPLICATES ===");
        db.addStudent(new Student(101, "Alice2", "alice2@email.com")); // Duplicate ID
        db.addStudent(new Student(104, "David", "alice@email.com")); // Duplicate email

        System.out.println();

        // List all
        db.listAllStudents();

        System.out.println();

        // Find by ID
        System.out.println("=== FIND BY ID ===");
        db.findStudentById(102);
        db.findStudentById(999);

        System.out.println();

        // Find by email
        System.out.println("=== FIND BY EMAIL ===");
        db.findStudentByEmail("charlie@email.com");
        db.findStudentByEmail("unknown@email.com");

        System.out.println();

        // Check emails
        System.out.println("=== CHECK EMAILS ===");
        db.checkEmailExists("bob@email.com");
        db.checkEmailExists("new@email.com");

        System.out.println();

        // Remove student
        System.out.println("=== REMOVING STUDENT ===");
        db.removeStudent(102);

        System.out.println();

        // List after removal
        db.listAllStudents();

        System.out.println();

        // Verify email was removed
        System.out.println("=== CHECK REMOVED EMAIL ===");
        db.checkEmailExists("bob@email.com");
    }
}