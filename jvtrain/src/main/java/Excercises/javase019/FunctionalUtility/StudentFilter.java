package Excercises.javase019.FunctionalUtility;

import java.util.*;
import java.util.function.Predicate;

class StudentFilter {

    // Filter collection using Predicate
    public static List<Student> filterStudents(List<Student> students, Predicate<Student> condition) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (condition.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    // Pre-defined filters (using method references where possible)
    public static Predicate<Student> honorRoll() {
        return s -> s.getGpa() >= 3.5;
    }

    public static Predicate<Student> ninthGraders() {
        return s -> s.getGrade() == 9;
    }

    public static Predicate<Student> nameStartsWith(String letter) {
        return s -> s.getName().startsWith(letter);
    }
}