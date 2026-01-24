package Excercises.javase009.Animalhierarchy;

abstract class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(getName() + " is flying.");
    }
}