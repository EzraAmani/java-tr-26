package Excercises.javase009.Vehicleindustry;

public class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String make, String model, int year, boolean hasSideCar) {
        super(make, model, year);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public String getInfo() {
        String sidecarInfo = hasSideCar ? " with sidecar" : "";
        return super.getInfo() + sidecarInfo;
    }
}