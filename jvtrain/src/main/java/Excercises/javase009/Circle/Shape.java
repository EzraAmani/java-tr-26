package Excercises.javase009.Circle;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }

    // Getters and setters
    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }
}
