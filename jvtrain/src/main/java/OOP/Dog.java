package OOP;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makesound() {
        System.out.println(name + " says: woof! woof!");
    }

}
