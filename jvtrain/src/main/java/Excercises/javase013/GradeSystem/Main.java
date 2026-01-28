package Excercises.javase013.GradeSystem;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        try {
            manager.addStudent("Alice");
            manager.setGrade("Alice", 150); // Invalid grade

        } catch (DuplicateStudentException e) {
            System.out.println("Duplicate error: " + e.getMessage());

        } catch (StudentNotFoundException | InvalidGradeException e) {
            // Both handled the same way
            System.out.println("Operation error: " + e.getMessage());

        } finally {
            System.out.println("Cleanup tasks...");
        }

        System.out.println("Program continues...");
    }
}