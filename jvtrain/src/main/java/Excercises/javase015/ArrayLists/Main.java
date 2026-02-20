package Excercises.javase015.ArrayLists;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Add students
        manager.addStudent(new Student(1, "Alice", "A"));
        manager.addStudent(new Student(2, "Bob", "B"));
        manager.addStudent(new Student(3, "Charlie", "A"));

        // System.out.println();

        // // Display all
        // manager.displayAllStudents();

        // System.out.println();

        // Find a student
        manager.findStudent("Bob");
        manager.findStudent("David");

        // System.out.println();

        // // Remove a student
        // manager.removeStudent(2);

        // System.out.println();

        // // Display after removal
        // manager.displayAllStudents();
    }
}