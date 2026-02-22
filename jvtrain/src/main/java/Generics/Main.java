package Generics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // printer<Integer> printer = new printer<>(13);
        // printer<String> printer2 = new printer<>("Hello Generics");
        // Pair<String, String> pair1 = new Pair<>("Moonwalk", "Dance");

        // // printer.print();
        // // printer2.print();

        // pair1.setKey("Love");

        // System.out.println(pair1.createList("apples", "mangoes"));

        // Box for String
        Box<String> stringBox = new Box<>("Hello Generics!");
        String content = stringBox.getContent(); // No casting needed
        System.out.println(stringBox);
        // Box for Integer
        Box<Integer> integerBox = new Box<>(42);
        int number = integerBox.getContent(); // Auto-unboxing
        System.out.println(integerBox);
        // Box for custom objects
        Box<Student> studentBox = new Box<>(new Student("Alice", 20));
        Student student = studentBox.getContent();
        System.out.println(studentBox);

    }
}
