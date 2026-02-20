package collections;

import java.util.ArrayList; // this is a concrete class that implements the list interface just below
import java.util.Iterator;
import java.util.List; // this is an interface
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        ArrayList<String> names3 = new ArrayList<>(20); // you can set initial capacity
        ArrayList<Integer> numbers = new ArrayList<>(5);

        names.add("liz");
        names.add("jeff");
        names.add("kim");
        names.add(2, "jake");

        // System.out.println("names: " + names);
        // System.out.println("Size: " + names.size());

        // String findname = names.get(0);
        // System.out.println(findname);

        // boolean haskim = names.contains("kim");
        // System.out.println("does kim exist?? " + haskim);

        // for (int i = 1; i <= 10; i++) {
        // numbers.add(i);
        // System.out.println("Added " + i + ", Size: " + numbers.size());
        // }

        // System.out.println(numbers.add(100));
        // System.out.println(numbers);

        // long startTime = System.nanoTime();
        // System.out.println(startTime);

        // for (String name : names) {
        // System.out.println(names);

        // }

        // Iterator<String> iterator = names.iterator();
        // while (iterator.hasNext()) {
        // String name = iterator.next();
        // System.out.println("name: " + name);
        // }

        names.forEach(name -> System.out.println("name: " + name));

        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println(queue);
        System.out.println("Process: " + queue.poll()); // Removes "First"
        System.out.println(queue);

    }
}

// this is just the beginning