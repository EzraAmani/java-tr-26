package linkedinterfacearraylists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        System.out.println("=== Student Management System ===\n");

        // Adding students
        System.out.println("1. Adding students:");
        manager.addStudent(new Student(1, "Alice", "A"));
        manager.addStudent(new Student(2, "Bob", "B"));
        manager.addStudent(new Student(3, "Charlie", "C"));

        // Display all students
        System.out.println("\n2. Displaying all students:");
        manager.displayAllStudents();

        // Finding a student
        System.out.println("3. Finding student with ID 2:");
        Student found = manager.findStudent(2);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Student not found.");
        }

        // Removing a student
        System.out.println("\n4. Removing student with ID 1:");
        manager.removeStudent(1);

        // Display after removal
        System.out.println("\n5. Students after removal:");
        manager.displayAllStudents();

        // Try to find removed student
        System.out.println("6. Trying to find removed student (ID 1):");
        Student notFound = manager.findStudent(1);
        if (notFound == null) {
            System.out.println("Student not found (as expected).");
        }

        // Add more students
        System.out.println("\n7. Adding more students:");
        manager.addStudent(new Student(4, "Diana", "A"));
        manager.addStudent(new Student(5, "Eve", "B"));

        // Final display
        System.out.println("\n8. Final student list:");
        manager.displayAllStudents();

        // Demonstrate ArrayList operations
        System.out.println("9. ArrayList Operations Demo:");
        ArrayList<Student> allStudents = manager.getAllStudents();

        // Check if empty
        System.out.println("Is list empty? " + allStudents.isEmpty());

        // Get size
        System.out.println("Number of students: " + allStudents.size());

        // Get student at index
        if (!allStudents.isEmpty()) {
            System.out.println("First student: " + allStudents.get(0));
        }

        // Clear all students
        allStudents.clear();
        System.out.println("\n10. After clearing all students:");
        manager.displayAllStudents();
    }
}
