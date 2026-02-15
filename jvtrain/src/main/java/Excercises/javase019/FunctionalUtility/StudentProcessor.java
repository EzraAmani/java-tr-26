package Excercises.javase019.FunctionalUtility;

import java.util.*;
import java.util.function.Consumer;

class StudentProcessor {

    // Process collection using Consumer
    public static void processStudents(List<Student> students, Consumer<Student> action) {
        for (Student student : students) {
            action.accept(student);
        }
    }

    // Pre-defined processors (using method references!)
    public static Consumer<Student> printStudent() {
        return System.out::println; // Method reference!
    }

    public static Consumer<Student> makeStudy() {
        return Student::study; // Method reference!
    }

    public static Consumer<Student> giveBonus(double bonus) {
        return s -> s.setGpa(s.getGpa() + bonus);
    }
}