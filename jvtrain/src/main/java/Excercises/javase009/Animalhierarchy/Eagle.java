package Excercises.javase009.Animalhierarchy;

class Eagle extends Bird {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " screeches.");
    }

    public void hunt() {
        System.out.println(getName() + " is hunting for prey.");
    }
}