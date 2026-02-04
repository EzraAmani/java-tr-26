package linkedinterfacearraylists;

import java.util.ArrayList;

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added: " + student);
    }

    // Remove student by ID
    public void removeStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                Student removed = students.remove(i);
                System.out.println("Removed: " + removed);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Find student by ID
    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("\n=== All Students ===");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("Total: " + students.size() + " students\n");
    }

    // Get list of all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}