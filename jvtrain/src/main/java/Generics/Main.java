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
        // Box<String> stringBox = new Box<>("Hello Generics!");
        // String content = stringBox.getContent(); // No casting needed
        // System.out.println(stringBox);
        // // Box for Integer
        // Box<Integer> integerBox = new Box<>(42);
        // int number = integerBox.getContent(); // Auto-unboxing
        // System.out.println(integerBox);
        // // Box for custom objects
        // Box<Student> studentBox = new Box<>(new Student("Alice", 20));
        // Student student = studentBox.getContent();
        // System.out.println(studentBox);

        // Create some animals
        Dog dog1 = new Dog("Rex");
        Dog dog2 = new Dog("Max");
        Cat cat1 = new Cat("Luna");
        Eagle eagle1 = new Eagle("Freedom");

        // --- DEMO 1: UNBOUNDED WILDCARD ---
        System.out.println("=== UNBOUNDED WILDCARD DEMO ===");
        ArrayList<String> names = new ArrayList<>();
        names.add("Zoo Visit");
        names.add("Feeding Time");
        Zoo.countAnimals(names); // Works with Strings!

        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(10);
        counts.add(5);
        Zoo.countAnimals(counts); // Works with Integers!

        // --- DEMO 2: UPPER BOUNDED (PRODUCER) ---
        System.out.println("\n=== UPPER BOUNDED DEMO (PRODUCER) ===");

        // Dog list (specific type)
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);

        // Cat list (different specific type)
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);

        // Mixed animal list
        ArrayList<Animal> mixed = new ArrayList<>();
        mixed.add(dog1);
        mixed.add(cat1);
        mixed.add(eagle1);

        // ALL work with feedAnimals (upper bounded)!
        Zoo.feedAnimals(dogs); // Dog list works!
        Zoo.feedAnimals(cats); // Cat list works!
        Zoo.feedAnimals(mixed); // Mixed list works!

        // --- DEMO 3: LOWER BOUNDED (CONSUMER) ---
        System.out.println("\n=== LOWER BOUNDED DEMO (CONSUMER) ===");

        ArrayList<Mammal> mammalList = new ArrayList<>(); // Exact type
        ArrayList<Animal> animalList = new ArrayList<>(); // Parent type
        ArrayList<Object> objectList = new ArrayList<>(); // Grandparent

        // ALL work with addMammals!
        Zoo.addMammals(mammalList); // Works!
        Zoo.addMammals(animalList); // Works! Animal is parent of Mammal
        Zoo.addMammals(objectList); // Works! Object is parent

        // This would NOT work:
        // ArrayList<Dog> dogOnly = new ArrayList<>();
        // Zoo.addMammals(dogOnly); // ERROR! Dog is child, not parent/same

        // --- DEMO 4: PECS COPY METHOD ---
        System.out.println("\n=== PECS COPY DEMO ===");

        ArrayList<Dog> sourceDogs = new ArrayList<>();
        sourceDogs.add(new Dog("Rocky"));
        sourceDogs.add(new Dog("Daisy"));

        ArrayList<Animal> destAnimals = new ArrayList<>();
        destAnimals.add(new Cat("Existing Cat")); // Already has a cat

        // Copy Dogs (source) to Animals (destination)
        Zoo.copyAnimals(sourceDogs, destAnimals);

        System.out.println("Destination now has:");
        for (Animal a : destAnimals) {
            System.out.println(" - " + a);
        }

        // --- DEMO 5: SEPARATE MAMMALS AND BIRDS ---
        System.out.println("\n=== PECS SEPARATION DEMO ===");

        // Create mixed zoo
        ArrayList<Animal> zoo = new ArrayList<>();
        zoo.add(new Dog("Charlie"));
        zoo.add(new Cat("Bella"));
        zoo.add(new Eagle("Thunder"));
        zoo.add(new Dog("Lucy"));
        zoo.add(new Bird("Tweety"));

        // Create empty containers for separation
        ArrayList<Mammal> mammals = new ArrayList<>();
        ArrayList<Bird> birds = new ArrayList<>();

        // Separate them!
        Zoo.separateMammalsAndBirds(zoo, mammals, birds);

        System.out.println("\nMammals section:");
        for (Mammal m : mammals) {
            System.out.println(" - " + m);
            m.breathe(); // Mammal-specific method!
        }

        System.out.println("\nBirds section:");
        for (Bird b : birds) {
            System.out.println(" - " + b);
            b.fly(); // Bird-specific method!
        }

    }
}
