package Excercises.javase017.iterator;

import java.util.*;

public class CollectionFilter {

    // 1. Filter even numbers from a list
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        Iterator<Integer> iterator = result.iterator();

        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num % 2 != 0) { // Keep only even numbers (remove odd ones)
                iterator.remove();
            }
        }
        return result;
    }

    // 2. Remove short strings (length < 3)
    public static List<String> removeShortStrings(List<String> strings) {
        List<String> result = new ArrayList<>(strings);
        Iterator<String> iterator = result.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().length() < 3) {
                iterator.remove();
            }
        }
        return result;
    }

    // 3. Filter students with grade below C
    public static class Student {
        String name;
        char grade;

        public Student(String name, char grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static List<Student> filterLowGradeStudents(List<Student> students) {
        List<Student> result = new ArrayList<>(students);
        Iterator<Student> iterator = result.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            // Assuming grades: A, B, C, D, F where C and above are passing
            if (student.grade == 'D' || student.grade == 'F') {
                iterator.remove();
            }
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test 1: Filter even numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("All numbers: " + numbers);
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("Even numbers: " + evenNumbers); // [2, 4, 6, 8, 10]

        // Test 2: Remove short strings
        List<String> strings = Arrays.asList("Hi", "Hello", "No", "Yes", "OK", "Java");
        List<String> longStrings = removeShortStrings(strings);
        System.out.println("Long strings: " + longStrings); // [Hello, Yes, Java]

        // Test 3: Filter low grade students
        List<Student> students = Arrays.asList(
                new Student("Alice", 'A'),
                new Student("Bob", 'D'),
                new Student("Charlie", 'C'),
                new Student("Diana", 'F'),
                new Student("Eve", 'B'));
        List<Student> goodStudents = filterLowGradeStudents(students);
        System.out.println("Students with C or better:");
        for (Student s : goodStudents) {
            System.out.println("  " + s.name + ": " + s.grade);
        }
        // Alice: A, Charlie: C, Eve: B
    }
}