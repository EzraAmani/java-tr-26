package Excercises.javase016.Studentdb;

import java.util.*;

public class StudentDatabase {
    // Map for fast lookup by ID
    HashMap<Integer, Student> studentsById = new HashMap<>();

    // Set to ensure unique emails
    HashSet<String> emails = new HashSet<>();

    // Add student (prevents duplicates by both ID and email)
    void addStudent(Student s) {
        // Check if ID already exists
        if (studentsById.containsKey(s.id)) {
            System.out.println("Error: Student with ID " + s.id + " already exists!");
            return;
        }

        // Check if email already exists
        if (emails.contains(s.email)) {
            System.out.println("Error: Email " + s.email + " already in use!");
            return;
        }

        // Add to both collections
        studentsById.put(s.id, s);
        emails.add(s.email);
        System.out.println("Added: " + s);
    }

    // Find student by ID (fast lookup using Map)
    void findStudentById(int id) {
        Student s = studentsById.get(id);
        if (s != null) {
            System.out.println("Found: " + s);
        } else {
            System.out.println("Student with ID " + id + " not found");
        }
    }

    // Find student by email
    void findStudentByEmail(String email) {
        for (Student s : studentsById.values()) {
            if (s.email.equals(email)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student with email " + email + " not found");
    }

    // Remove student by ID
    void removeStudent(int id) {
        Student s = studentsById.remove(id);
        if (s != null) {
            emails.remove(s.email);
            System.out.println("Removed: " + s);
        } else {
            System.out.println("Student with ID " + id + " not found");
        }
    }

    // List all students
    void listAllStudents() {
        if (studentsById.isEmpty()) {
            System.out.println("No students in database");
        } else {
            System.out.println("=== ALL STUDENTS (" + studentsById.size() + ") ===");
            // Sort by ID for nice display
            ArrayList<Integer> sortedIds = new ArrayList<>(studentsById.keySet());
            Collections.sort(sortedIds);

            for (int id : sortedIds) {
                System.out.println("  " + studentsById.get(id));
            }
        }
    }

    // Check if email exists (using Set)
    void checkEmailExists(String email) {
        if (emails.contains(email)) {
            System.out.println("Email " + email + " is already registered");
        } else {
            System.out.println("Email " + email + " is available");
        }
    }
}