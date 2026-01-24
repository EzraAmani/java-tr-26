package Excercises.javase009.Animalhierarchy;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method every animal must implement
    public abstract void makeSound();

    // Common method
    public void eat() {
        System.out.println(name + " is eating.");
    }
}
