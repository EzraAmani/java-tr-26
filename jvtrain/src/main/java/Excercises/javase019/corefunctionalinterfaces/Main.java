package Excercises.javase019.corefunctionalinterfaces;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // 1. SUPPLIER - Gives us a student
        Supplier<Student> studentSupplier = () -> new Student("Alice", 85);
        Student student = studentSupplier.get();

        // 2. FUNCTION - Converts score to grade
        Function<Integer, String> getGrade = score -> {
            if (score >= 90)
                return "A";
            if (score >= 80)
                return "B";
            if (score >= 70)
                return "C";
            return "F";
        };

        // 3. PREDICATE - Checks if passed
        Predicate<Integer> isPassing = score -> score >= 60;

        // 4. CONSUMER - Prints result
        Consumer<Student> printResult = s -> {
            String grade = getGrade.apply(s.score);
            boolean passed = isPassing.test(s.score);
            System.out.println(s.name + " - Score: " + s.score +
                    ", Grade: " + grade +
                    ", Status: " + (passed ? "✅ PASS" : "❌ FAIL"));
        };

        printResult.accept(student);

        // Test multiple students
        List<Student> students = Arrays.asList(
                new Student("Bob", 92),
                new Student("Charlie", 45),
                new Student("Diana", 78));

        System.out.println("\n📊 Class Results:");
        students.forEach(printResult);
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}