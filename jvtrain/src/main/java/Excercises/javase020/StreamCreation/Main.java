package Excercises.javase020.StreamCreation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   STREAM CREATION PRACTICE");
        System.out.println("=================================\n");

        // Run all demonstrations
        CollectionStreams.demonstrate();
        PatternStreams.demonstrate();
        PrimitiveStreams.demonstrate();
        InfiniteStreams.demonstrate();
        CombineStreams.demonstrate();

        // Bonus: Real-world example combining everything
        System.out.println("\n=== BONUS: REAL-WORLD EXAMPLE ===");
        System.out.println("Processing student grades:\n");

        // Create streams from multiple sources
        IntStream grades1 = IntStream.of(85, 90, 78);
        IntStream grades2 = IntStream.rangeClosed(80, 84);
        IntStream grades3 = Stream.generate(() -> 75 + (int) (Math.random() * 20))
                .limit(3)
                .mapToInt(Integer::intValue);

        // Combine all streams
        double average = IntStream.concat(IntStream.concat(grades1, grades2), grades3)
                .peek(g -> System.out.print(g + " "))
                .average()
                .orElse(0);

        System.out.println("\nAverage grade: " + average);

        System.out.println("\n=================================");
        System.out.println("   END OF DEMONSTRATION");
        System.out.println("=================================");
    }
}