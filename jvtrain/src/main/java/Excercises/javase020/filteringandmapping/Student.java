package Excercises.javase020.filteringandmapping;

// Student.java
import java.util.*;

class Student {
    String name;
    int age;
    double grade;

    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return name + "(" + age + ", grade:" + grade + ")";
    }
}