package Excercises.javase018.genericutilities;

import java.util.*;

public class GenericUtils {

    // 1. Find minimum/maximum in array (Comparable bound)
    public static <T extends Comparable<T>> T findMin(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    // 2. Calculate sum of numbers (Number bound)
    public static <T extends Number> double sum(T[] numbers) {
        double total = 0.0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }

    // 3. Sort list of comparable objects
    public static <T extends Comparable<T>> List<T> sortList(List<T> list) {
        if (list == null)
            return new ArrayList<>();
        List<T> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }

    // 4. Filter numbers greater than threshold
    public static <T extends Number> List<T> filterGreaterThan(T[] numbers, T threshold) {
        List<T> result = new ArrayList<>();
        double thresholdValue = threshold.doubleValue();

        for (T num : numbers) {
            if (num.doubleValue() > thresholdValue) {
                result.add(num);
            }
        }
        return result;
    }

    // Bonus: Filter for any comparable type
    public static <T extends Comparable<T>> List<T> filterGreaterThanComparable(T[] array, T threshold) {
        List<T> result = new ArrayList<>();
        for (T element : array) {
            if (element.compareTo(threshold) > 0) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Generic Utility Methods ===\n");

        // Test 1: Min/Max with Strings
        System.out.println("1. Testing Min/Max (Comparable):");
        String[] words = { "banana", "apple", "cherry", "date" };
        System.out.println("   Min string: " + findMin(words));
        System.out.println("   Max string: " + findMax(words));

        // Test 2: Min/Max with Integers
        Integer[] numbers = { 42, 17, 89, 5, 31 };
        System.out.println("   Min number: " + findMin(numbers));
        System.out.println("   Max number: " + findMax(numbers));

        // Test 3: Sum of numbers
        System.out.println("\n2. Testing Sum (Number):");
        System.out.println("   Sum of integers: " + sum(numbers));

        Double[] doubles = { 1.5, 2.7, 3.14, 4.2 };
        System.out.println("   Sum of doubles: " + sum(doubles));

        // Test 4: Sort list
        System.out.println("\n3. Testing Sort (Comparable):");
        List<String> fruits = Arrays.asList("banana", "apple", "cherry", "date");
        System.out.println("   Original: " + fruits);
        System.out.println("   Sorted: " + sortList(fruits));

        List<Integer> numsList = Arrays.asList(42, 17, 89, 5, 31);
        System.out.println("   Original numbers: " + numsList);
        System.out.println("   Sorted numbers: " + sortList(numsList));

        // Test 5: Filter numbers greater than threshold
        System.out.println("\n4. Testing Filter (Number):");
        System.out.println("   Numbers > 20: " + filterGreaterThan(numbers, 20));
        System.out.println("   Doubles > 2.0: " + filterGreaterThan(doubles, 2.0));

        // Test 6: Filter comparable types
        System.out.println("\n5. Testing Filter (Comparable):");
        System.out.println("   Strings > 'banana': " + filterGreaterThanComparable(words, "banana"));
        System.out.println("   Numbers > 30: " + filterGreaterThanComparable(numbers, 30));
    }

}