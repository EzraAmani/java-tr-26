package assessments.assessment2.Question2;

public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Alice", 101, 50000);
        Manager mgr1 = new Manager("Bob", 102, 80000, "IT");
        Developer dev1 = new Developer("Charlie", 103, 60000, "Java");

        emp1.displayInfo();

        dev1.displayInfo();

        mgr1.displayInfo();
    }
}
