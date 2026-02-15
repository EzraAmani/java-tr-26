package Excercises.javase020.StreamCreation;

import java.util.stream.*;

class PatternStreams {

    public static void demonstrate() {
        System.out.println("\n=== STREAMS WITH PATTERNS ===\n");

        // 1. Stream.of() - Create from values
        System.out.println("Stream.of():");
        Stream.of("Dog", "Cat", "Bird")
                .forEach(a -> System.out.println("  " + a));

        // 2. Stream.builder() - Build step by step
        System.out.println("\nStream.builder():");
        Stream.<String>builder()
                .add("One")
                .add("Two")
                .add("Three")
                .build()
                .forEach(s -> System.out.println("  " + s));

        // 3. Stream.iterate() - Generate with pattern
        System.out.println("\nStream.iterate() (even numbers):");
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(n -> System.out.println("  " + n));

        // 4. Stream.generate() - Generate with supplier
        System.out.println("\nStream.generate() (random numbers):");
        Stream.generate(() -> Math.random())
                .limit(3)
                .forEach(n -> System.out.println("  " + n));

        // 5. Pattern: Fibonacci sequence
        System.out.println("\nFibonacci sequence:");
        Stream.iterate(new int[] { 0, 1 }, fib -> new int[] { fib[1], fib[0] + fib[1] })
                .limit(8)
                .map(fib -> fib[0])
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}