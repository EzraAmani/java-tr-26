package Polymorphism.Animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makessound() {
        System.out.println(name + " makes the sound woof!!");
    }

}
