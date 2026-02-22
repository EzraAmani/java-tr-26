package Excercises.javase018.Wildcards;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. MERGE TWO LISTS ===");
        List<Integer> ints1 = Arrays.asList(1, 2, 3);
        List<Integer> ints2 = Arrays.asList(4, 5, 6);
        List<Number> merged = WildcardUtilities.merge(ints1, ints2);
        System.out.print("Merged: ");
        WildcardUtilities.printList(merged);

        System.out.println("\n=== 2. FILTER NUMBERS > THRESHOLD ===");
        List<Number> mixedNumbers = Arrays.asList(5, 10.5, 3, 8.7, 15, 2.3);
        List<Double> filtered = WildcardUtilities.filterGreaterThan(mixedNumbers, 7.0);
        System.out.print("Numbers > 7.0: ");
        WildcardUtilities.printList(filtered);

        System.out.println("\n=== 3. COPY BETWEEN NUMBER TYPES ===");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        WildcardUtilities.copy(integers, numbers); // Integer -> Number
        WildcardUtilities.copy(integers, objects); // Integer -> Object

        System.out.print("Numbers after copy: ");
        WildcardUtilities.printList(numbers);
        System.out.print("Objects after copy: ");
        WildcardUtilities.printList(objects);

        System.out.println("\n=== 4. ADD ALL ELEMENTS ===");
        List<String> source = Arrays.asList("A", "B", "C");
        List<Object> dest = new ArrayList<>();
        dest.add("X");

        WildcardUtilities.addAll(source, dest);
        System.out.print("Destination after addAll: ");
        WildcardUtilities.printList(dest);

        System.out.println("\n=== 5. FIND MAXIMUM ===");
        List<Double> doubles = Arrays.asList(3.5, 7.2, 1.8, 9.3, 4.6);
        Double maxDouble = WildcardUtilities.max(doubles);
        System.out.println("Max double: " + maxDouble);

        List<Integer> intList = Arrays.asList(45, 23, 67, 12, 89, 34);
        Integer maxInt = WildcardUtilities.max(intList);
        System.out.println("Max integer: " + maxInt);

        System.out.println("\n=== 6. ADD NUMBERS TO DIFFERENT TYPES ===");
        List<Integer> intSources = Arrays.asList(10, 20, 30);
        List<Number> numDest = new ArrayList<>();
        List<Object> objDest = new ArrayList<>();

        WildcardUtilities.addNumbers(intSources, numDest);
        WildcardUtilities.addNumbers(intSources, objDest);

        System.out.print("Number destination: ");
        WildcardUtilities.printList(numDest);
        System.out.print("Object destination: ");
        WildcardUtilities.printList(objDest);

        System.out.println("\n=== 7. PECS PRINCIPLE DEMONSTRATION ===");
        demonstratePECS();
    }

    public static void demonstratePECS() {
        System.out.println("PECS: Producer Extends, Consumer Super");

        // Producer - use EXTENDS (you're READING items)
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<? extends Number> producer = intList; // Can only READ Numbers

        Number n = producer.get(0); // OK - reading
        // producer.add(4.5); // ERROR - can't add, don't know exact type

        // Consumer - use SUPER (you're WRITING items)
        List<Number> consumerList = new ArrayList<>();
        List<? super Integer> consumer = consumerList; // Can WRITE Integers

        consumer.add(10); // OK - adding Integer
        consumer.add(20); // OK - adding Integer
        // Integer i = consumer.get(0); // ERROR - might be Object or Number

        System.out.println("Consumer contains: " + consumerList);

        // Perfect example of PECS in Collections.copy()
        List<Number> dest = new ArrayList<>();
        List<Integer> src = Arrays.asList(1, 2, 3);

        // Collections.copy(dest, src); // dest consumes, src produces
        // Signature: copy(List<? super T> dest, List<? extends T> src)

        // Manually demonstrate
        dest.add(5); // Add something first to show insertion
        WildcardUtilities.copy(src, dest);
        System.out.println("After copy: " + dest);
    }
}