package Excercises.javase009.employeeshierarchy;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // A method all employees have
    public void work() {
        System.out.println(name + " is working.");
    }

    // Display employee details
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
}
