package Excercises.javase019.Methodreference;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // 1️⃣ STATIC METHOD REFERENCE
        // Lambda
        Function<Integer, String> lambda1 = num -> Integer.toHexString(num);
        // Method Reference
        Function<Integer, String> ref1 = Integer::toHexString;
        System.out.println("Static: " + ref1.apply(16)); // 10

        // 2️⃣ INSTANCE METHOD REFERENCE (on specific object)
        String message = "hello";
        // Lambda
        Supplier<String> lambda2 = () -> message.toUpperCase();
        // Method Reference
        Supplier<String> ref2 = message::toUpperCase;
        System.out.println("Instance on object: " + ref2.get()); // HELLO

        // 3️⃣ INSTANCE METHOD REFERENCE (on parameter)
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Lambda
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name));

        // Method Reference (shorter!)
        names.stream()
                .map(String::toUpperCase) // Method reference on parameter
                .forEach(System.out::println); // Method reference on specific object

        // 4️⃣ CONSTRUCTOR REFERENCE
        // Lambda
        Supplier<ArrayList<String>> lambda3 = () -> new ArrayList<>();
        // Method Reference
        Supplier<ArrayList<String>> ref3 = ArrayList::new;

        ArrayList<String> list = ref3.get();
        list.add("java");
        System.out.println("Constructor ref: " + list);
    }
}