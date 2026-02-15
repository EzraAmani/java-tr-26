package Excercises.javase020.StreamCreation;

import java.util.stream.*;

class PrimitiveStreams {

    public static void demonstrate() {
        System.out.println("\n=== PRIMITIVE STREAMS ===\n");

        // 1. IntStream.range() - Exclusive end
        System.out.println("IntStream.range(1, 6):");
        IntStream.range(1, 6)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2. IntStream.rangeClosed() - Inclusive end
        System.out.println("\nIntStream.rangeClosed(1, 5):");
        IntStream.rangeClosed(1, 5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 3. LongStream
        System.out.println("\nLongStream.range(10, 15):");
        LongStream.range(10, 15)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 4. DoubleStream
        System.out.println("\nDoubleStream (random):");
        DoubleStream.generate(() -> Math.random() * 100)
                .limit(5)
                .forEach(n -> System.out.printf("%.2f ", n));
        System.out.println();

        // 5. Stream with step (custom)
        System.out.println("\nCustom step (0, 3, 6, 9):");
        IntStream.iterate(0, i -> i + 3)
                .limit(4)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}