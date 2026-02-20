package Excercises.javase017.collectionfilter;

import java.util.*;

public class CollectionFilter {

    // Filter even numbers (keep only odd)
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        Iterator<Integer> it = result.iterator();

        while (it.hasNext()) {
            int num = it.next();
            if (num % 2 == 0) { // Even number
                it.remove();
            }
        }
        return result;
    }

    // Remove short strings (length < 3)
    public static List<String> filterShortStrings(List<String> strings) {
        List<String> result = new ArrayList<>(strings);
        Iterator<String> it = result.iterator();

        while (it.hasNext()) {
            String s = it.next();
            if (s.length() < 3) {
                it.remove();
            }
        }
        return result;
    }

    // Filter students with grade below C (keep only A, B, C)
    public static List<Student> filterLowGrades(List<Student> students) {
        List<Student> result = new ArrayList<>(students);
        Iterator<Student> it = result.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.grade.equals("D") || s.grade.equals("F")) {
                it.remove();
            }
        }
        return result;
    }

    // Generic method - works with any type
    public static <T> List<T> filter(List<T> list, FilterCondition<T> condition) {
        List<T> result = new ArrayList<>(list);
        Iterator<T> it = result.iterator();

        while (it.hasNext()) {
            T item = it.next();
            if (condition.shouldRemove(item)) {
                it.remove();
            }
        }
        return result;
    }

    // Filter condition interface
    interface FilterCondition<T> {
        boolean shouldRemove(T item);
    }
}