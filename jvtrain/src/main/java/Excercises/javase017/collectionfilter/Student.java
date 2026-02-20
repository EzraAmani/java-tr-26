package Excercises.javase017.collectionfilter;

public class Student {
    String name;
    String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + "(" + grade + ")";
    }
}