package Excercises.javase011.DrawingApplication;

public class Main {
    public static void main(String[] args) {
        // Create shapes
        Shape circle = new Circle();
        Shape square = new Square();
        Shape triangle = new Triangle();

        Shape[] shapes = { circle, square, triangle };

        System.out.println("=== Drawing Shapes ===");
        for (Shape shape : shapes) {
            shape.draw(); // Same method, different behavior!
        }
    }

}
