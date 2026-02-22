package Excercises.javase018.Wildcards;

import java.util.*;

public class WildcardUtilities {

    // 1. Merge two lists - PRODUCER uses EXTENDS
    public static <T> List<T> merge(List<? extends T> list1, List<? extends T> list2) {
        List<T> result = new ArrayList<>();
        result.addAll(list1); // list1 produces T elements
        result.addAll(list2); // list2 produces T elements
        return result;
    }

    // 2. Filter numbers greater than threshold - PRODUCER uses EXTENDS
    public static List<Double> filterGreaterThan(List<? extends Number> numbers, double threshold) {
        List<Double> result = new ArrayList<>();
        for (Number num : numbers) {
            double value = num.doubleValue();
            if (value > threshold) {
                result.add(value);
            }
        }
        return result;
    }

    // 3. Copy between different number types - COPY pattern
    public static <T extends Number> void copy(List<? extends T> source, List<? super T> destination) {
        for (T item : source) {
            destination.add(item); // source produces, destination consumes
        }
    }

    // 4. Add all elements - CONSUMER uses SUPER
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source); // source produces, destination consumes
    }

    // 5. Find maximum in a list - PRODUCER uses EXTENDS
    public static <T extends Comparable<T>> T max(List<? extends T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        Iterator<? extends T> iterator = list.iterator();
        T max = iterator.next();

        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    // 6. Add numbers of one type to another - CONSUMER uses SUPER
    public static void addNumbers(List<? extends Number> source, List<? super Number> destination) {
        for (Number num : source) {
            destination.add(num);
        }
    }

    // 7. Print any list - READ-ONLY uses EXTENDS
    public static void printList(List<?> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}