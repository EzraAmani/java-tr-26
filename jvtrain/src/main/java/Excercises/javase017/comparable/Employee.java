package Excercises.javase017.comparable;

class Employee implements Comparable<Employee> {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        // First compare by department
        int deptCompare = this.department.compareTo(other.department);
        if (deptCompare != 0)
            return deptCompare;

        // If departments are equal, compare by salary (higher first)
        int salaryCompare = Double.compare(other.salary, this.salary); // Note: reversed for descending
        if (salaryCompare != 0)
            return salaryCompare;

        // If salaries are equal, compare by name
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return department + " - " + name + " ($" + salary + ")";
    }
}