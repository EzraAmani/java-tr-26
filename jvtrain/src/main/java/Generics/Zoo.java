package Generics;

import java.util.*;

public class Zoo {

    // 1. UNBOUNDED WILDCARD - Just count anything!
    public static void countAnimals(ArrayList<?> anything) {
        System.out.println("Total items: " + anything.size());
        // Can only read as Object
        for (Object obj : anything) {
            System.out.println(" - " + obj);
        }
    }

    // 2. UPPER BOUNDED - FEEDING time! (PRODUCER - we READ animals)
    public static void feedAnimals(ArrayList<? extends Animal> animals) {
        System.out.println("\n🍖 Feeding time!");
        // We can READ as Animal (upper bound)
        for (Animal a : animals) {
            a.eat(); // All animals can eat
            // That's all we know for sure!
        }
    }

    // 3. LOWER BOUNDED - ADDING mammals to collection (CONSUMER - we ADD mammals)
    public static void addMammals(ArrayList<? super Mammal> container) {
        System.out.println("\n📦 Adding mammals to container:");
        // We can ADD Mammals and their children
        container.add(new Dog("Buddy")); // Dog is Mammal
        container.add(new Cat("Whiskers")); // Cat is Mammal
        container.add(new Mammal("Generic Mammal"));

        // Can only READ as Object (lower bound)
        for (Object o : container) {
            System.out.println("Container has: " + o);
        }
    }

    // 4. PECS in action - COPY method!
    public static <T> void copyAnimals(
            ArrayList<? extends T> source, // PRODUCER - gives us T
            ArrayList<? super T> destination) { // CONSUMER - receives T
        System.out.println("\n📋 Copying animals:");
        for (T item : source) {
            destination.add(item);
            System.out.println("Copied: " + item);
        }
    }

    // 5. Another PECS example - SEPARATE by type!
    public static void separateMammalsAndBirds(
            ArrayList<? extends Animal> allAnimals, // PRODUCER
            ArrayList<? super Mammal> mammalContainer, // CONSUMER for mammals
            ArrayList<? super Bird> birdContainer) { // CONSUMER for birds

        System.out.println("\n🔀 Separating animals:");
        for (Animal a : allAnimals) {
            if (a instanceof Mammal) {
                mammalContainer.add((Mammal) a);
                System.out.println(a + " goes to mammal section");
            } else if (a instanceof Bird) {
                birdContainer.add((Bird) a);
                System.out.println(a + " goes to bird section");
            }
        }
    }
}