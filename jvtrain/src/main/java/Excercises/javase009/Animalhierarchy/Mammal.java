package Excercises.javase009.Animalhierarchy;

// First-level subclass
abstract class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    public void breathe() {
        System.out.println(getName() + " is breathing air.");
    }
}