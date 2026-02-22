package Generics;

// The hierarchy
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }

    public String toString() {
        return name;
    }
}

class Mammal extends Animal {
    Mammal(String name) {
        super(name);
    }

    void breathe() {
        System.out.println(name + " is breathing");
    }
}

class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    void fly() {
        System.out.println(name + " is flying");
    }
}

class Dog extends Mammal {
    Dog(String name) {
        super(name);
    }

    void bark() {
        System.out.println(name + " says Woof!");
    }
}

class Cat extends Mammal {
    Cat(String name) {
        super(name);
    }

    void meow() {
        System.out.println(name + " says Meow!");
    }
}

class Eagle extends Bird {
    Eagle(String name) {
        super(name);
    }

    void hunt() {
        System.out.println(name + " is hunting");
    }
}