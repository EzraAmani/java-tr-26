package Excercises.javase009.Animalhierarchy;

class Dog extends Mammal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching a ball.");
    }
}