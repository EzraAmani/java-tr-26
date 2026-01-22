package Excercises.javase008;

public class Car {
    private String make;
    private String model;
    private int year;
    private double price;

    // Default constructor
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 2000;
        this.price = 0.0;
    }

    // Constructor with parameters
    public Car(String make, String model, int year, double price) {
        setMake(make);
        setModel(model);
        setYear(year);
        setPrice(price);
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    // Setters with validation
    public void setMake(String make) {
        if (make != null && !make.isBlank()) {
            this.make = make;
        } else {
            System.out.println("Invalid make. Keeping previous value.");
        }
    }

    public void setModel(String model) {
        if (model != null && !model.isBlank()) {
            this.model = model;
        } else {
            System.out.println("Invalid model. Keeping previous value.");
        }
    }

    public void setYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        if (year > 1885 && year <= currentYear) { // first car ~1886
            this.year = year;
        } else {
            System.out.println("Invalid year. Keeping previous value.");
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative. Keeping previous value.");
        }
    }

    // Display car information
    public void displayInfo() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
}
