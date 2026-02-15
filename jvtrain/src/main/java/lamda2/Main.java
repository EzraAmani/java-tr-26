package lamda2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Cat myCat = new Cat();
        // myCat.print();
        // printThing(
        // () -> {
        // System.out.println("Meow");
        // });

        // public static void printSquare(int number) {
        // int square = number * number;
        // System.out.println("The square of " + number + " is: " + square);
        // }

        // Store lambda in a variable
        Consumer<Integer> printSquare = number -> System.out
                .println("The square of " + number + " is: " + (number * number));

        // Use it
        // printSquare.accept(5); // Prints: The square of 5 is: 25

        // List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        // System.out.println("=== Printing names ===");
        // names.forEach(name -> System.out.println(name));

        // predicate returns true/false

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(8));

    }

    static void printThing(Printable thing) {
        thing.print();
    }

}
