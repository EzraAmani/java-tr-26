package Excercises.javase013.GradeSystem;

import java.util.HashMap;

class StudentManager {
    private HashMap<String, Student> students = new HashMap<>();

    public void addStudent(String name) throws DuplicateStudentException {
        if (students.containsKey(name)) {
            throw new DuplicateStudentException("Student already exists: " + name);
        }
        students.put(name, new Student(name));
        System.out.println("Added student: " + name);
    }

    public Student findStudent(String name) throws StudentNotFoundException {
        Student student = students.get(name);
        if (student == null) {
            throw new StudentNotFoundException("Student not found: " + name);
        }
        return student;
    }

    public void setGrade(String name, int grade) throws StudentNotFoundException, InvalidGradeException {
        Student student = findStudent(name); // throws StudentNotFoundException
        student.setGrade(grade); // throws InvalidGradeException
        System.out.println("Set grade for " + name + ": " + grade);
    }

    public void displayAllStudents() {
        System.out.println("\nAll Students:");
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}
