package Excercises.javase009.employeeshierarchy;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101, 50000);
        Manager mgr = new Manager("Bob", 102, 80000, 5);
        Developer dev = new Developer("Charlie", 103, 60000, "Java");
        Intern intern = new Intern("David", 104, 20000, 6);

        emp.displayInfo();
        emp.work();

        mgr.displayInfo();
        mgr.work();

        dev.displayInfo();
        dev.work();

        intern.displayInfo();
        intern.work();
    }
}
