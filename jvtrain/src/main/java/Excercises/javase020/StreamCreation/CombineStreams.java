package Excercises.javase020.StreamCreation;

import java.util.*;
import java.util.stream.*;

class CombineStreams {

    public static void demonstrate() {
        System.out.println("\n=== COMBINING STREAMS ===\n");

        // 1. Stream.concat() - Join two streams
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("D", "E", "F");

        System.out.println("Stream.concat():");
        Stream.concat(stream1, stream2)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 2. flatMap() - Flatten multiple streams
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("One", "Two"),
                Arrays.asList("Three", "Four"),
                Arrays.asList("Five", "Six"));

        System.out.println("\nflatMap() - Flatten lists:");
        listOfLists.stream()
                .flatMap(list -> list.stream())
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 3. Combine multiple arrays
        String[] array1 = { "Red", "Green" };
        String[] array2 = { "Blue", "Yellow" };
        String[] array3 = { "Purple", "Orange" };

        System.out.println("\nCombine multiple arrays:");
        Stream.of(array1, array2, array3)
                .flatMap(Arrays::stream)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 4. Combine with numbers
        IntStream ints1 = IntStream.range(1, 4);
        IntStream ints2 = IntStream.range(5, 8);

        System.out.println("\nCombine IntStreams:");
        IntStream.concat(ints1, ints2)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 5. Combine different sources
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        Set<Integer> moreNumbers = new HashSet<>(Arrays.asList(40, 50));

        System.out.println("\nCombine List and Set:");
        Stream.concat(numbers.stream(), moreNumbers.stream())
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}