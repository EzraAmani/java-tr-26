package Excercises.javase020.StreamCreation;

import java.util.stream.*;

class InfiniteStreams {

    public static void demonstrate() {
        System.out.println("\n=== INFINITE STREAMS WITH LIMITS ===\n");

        // 1. Infinite stream with limit
        System.out.println("First 5 natural numbers:");
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2. Infinite random numbers
        System.out.println("\nFirst 3 random numbers:");
        Stream.generate(Math::random)
                .limit(3)
                .forEach(n -> System.out.printf("%.2f ", n));
        System.out.println();

        // 3. Powers of 2
        System.out.println("\nFirst 6 powers of 2:");
        Stream.iterate(1, n -> n * 2)
                .limit(6)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 4. Odd numbers
        System.out.println("\nFirst 5 odd numbers:");
        Stream.iterate(1, n -> n + 2)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 5. Multiplication table
        System.out.println("\nMultiplication table of 3 (first 5):");
        Stream.iterate(3, n -> n + 3)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}