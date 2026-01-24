package Excercises.javase009.Vehicleindustry;

public class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println(make + " " + model + " starting...");
    }

    public void stop() {
        System.out.println(make + " " + model + " stopping...");
    }

    public String getInfo() {
        return year + " " + make + " " + model;
    }
}
