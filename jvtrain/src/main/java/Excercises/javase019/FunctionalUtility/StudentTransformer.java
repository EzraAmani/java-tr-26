package Excercises.javase019.FunctionalUtility;

import java.util.*;
import java.util.function.Function;

class StudentTransformer {

    // Transform collection using Function
    public static <R> List<R> transformStudents(List<Student> students, Function<Student, R> transformer) {
        List<R> result = new ArrayList<>();
        for (Student student : students) {
            result.add(transformer.apply(student));
        }
        return result;
    }

    // Pre-defined transformers (using method references!)
    public static Function<Student, String> toName() {
        return Student::getName; // Method reference!
    }

    public static Function<Student, Double> toGpa() {
        return Student::getGpa; // Method reference!
    }

    public static Function<Student, String> toStudentCard() {
        return s -> s.getName() + " - Grade: " + s.getGrade() + " - GPA: " + s.getGpa();
    }
}