package Excercises.javase017.comparable2;

class Employee2 {
    String name;
    double salary;

    public Employee2(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Add getter method
    public double getSalary() {
        return salary;
    }

    // Add getter for name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ($" + salary + ")";
    }
}