package Excercises.javase019.FunctionalUtility;

import java.util.*;

class Student {
    private String name;
    private int grade;
    private double gpa;

    public Student(String name, int grade, double gpa) {
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void study() {
        System.out.println(name + " is studying... 📚");
    }

    @Override
    public String toString() {
        return name + " (Grade " + grade + ", GPA: " + gpa + ")";
    }
}