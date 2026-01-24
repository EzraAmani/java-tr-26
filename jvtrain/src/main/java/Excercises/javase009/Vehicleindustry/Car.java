package Excercises.javase009.Vehicleindustry;

public class Car extends Vehicle {
    private int doors;

    public Car(String make, String model, int year, int doors) {
        super(make, model, year);
        this.doors = doors;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " with " + doors + " doors";
    }
}
