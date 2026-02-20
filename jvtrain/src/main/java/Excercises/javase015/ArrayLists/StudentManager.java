package Excercises.javase015.ArrayLists;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    // Add student
    void addStudent(Student s) {
        students.add(s);
        System.out.println("Added: " + s);
    }

    // Remove student by id
    void removeStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                Student removed = students.remove(i);
                System.out.println("Removed: " + removed);
                return;
            }
        }
        System.out.println("Student with id " + id + " not found");
    }

    // Find student by name
    void findStudent(String name) {
        for (Student s : students) {
            if (s.name.equals(name)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student '" + name + "' not found");
    }

    // Display all students
    void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in list");
        } else {
            System.out.println("All Students:");
            for (Student s : students) {
                System.out.println("  " + s);
            }
        }
    }
}