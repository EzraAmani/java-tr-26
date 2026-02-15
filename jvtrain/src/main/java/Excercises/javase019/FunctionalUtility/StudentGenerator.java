package Excercises.javase019.FunctionalUtility;

import java.util.*;
import java.util.function.Supplier;

class StudentGenerator {

    // Generate data using Supplier
    public static List<Student> generateStudents(Supplier<Student> generator, int count) {
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(generator.get());
        }
        return result;
    }

    // Pre-defined generators
    public static Supplier<Student> defaultStudent() {
        return () -> new Student("New Student", 9, 0.0);
    }

    public static Supplier<Student> randomStudent() {
        Random rand = new Random();
        String[] names = { "Emma", "Liam", "Olivia", "Noah", "Ava" };
        int[] grades = { 9, 10, 11, 12 };

        return () -> {
            String name = names[rand.nextInt(names.length)];
            int grade = grades[rand.nextInt(grades.length)];
            double gpa = 2.0 + (rand.nextDouble() * 2.0); // 2.0 - 4.0
            return new Student(name, grade, Math.round(gpa * 10) / 10.0);
        };
    }

    public static Supplier<Student> honorStudent() {
        return () -> new Student("Honor Student", 12, 4.0);
    }
}