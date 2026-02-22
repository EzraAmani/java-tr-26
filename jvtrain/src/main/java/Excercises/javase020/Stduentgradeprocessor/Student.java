package Excercises.javase020.Stduentgradeprocessor;

// Student.java
import java.util.*;

class Student {
    int id;
    String name;
    String grade; // "Freshman", "Sophomore", "Junior", "Senior"
    double gpa;
    List<String> courses;

    Student(int id, String name, String grade, double gpa, List<String> courses) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return name + " (" + grade + ", GPA:" + gpa + ")";
    }
}