package Excercises.javase011.ShapePolymorphism;

class Triangle extends Shape {
    private double base;
    private double height;
    private double side1, side2; // for perimeter calculation

    public Triangle(String color, boolean filled, double base, double height, double side1, double side2) {
        super(color, filled);
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        return base + side1 + side2;
    }

    @Override
    public String toString() {
        return "Triangle[" + super.toString() + ", base=" + base + ", height=" + height + "]";
    }
}
