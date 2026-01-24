package assessments.assessment2.Question5;

public class Main {

}

// This si method overloading because you can see a method with similar
// parameters but the two methods are doing different things

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

// This is method overiding as what is in parent will be replaced with what is
// in child

class Parent {
    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child show");
    }
}

// If we make a field private as shown below, we can prevent direct access and
// this will protect the data in it
// for example in the class below, balance field will always start at 0 and one
// cannot set it to say 100000000 creating an invalid account

class Account {
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// super is used when Calling a parent class constructor, calling a parent class
// method and accessing a parent class variable

class Employee {
    double salary = 50000;

    Employee(String name) {
        System.out.println("Employee constructor");
    }

    void display() {
        System.out.println("Employee display");
    }
}

class Manager extends Employee {

    Manager(String name) {
        super(name); // calls parent constructor
    }

    void showDetails() {
        super.display(); // calls parent method
        System.out.println(super.salary); // access parent variable
    }
}

// the @override will ensure that what runs is what is in the child class and
// not the super class
class top {
    void greet() {
        System.out.println("Hello");
    }
}

class bottom extends top {

    @Override
    void greet() {
        System.out.println("Hi");
    }
}

// the code below is very maintainable in that encapsulation bundles data and
// behavior together, hides internal implementation, allows changes without
// breaking other code
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
