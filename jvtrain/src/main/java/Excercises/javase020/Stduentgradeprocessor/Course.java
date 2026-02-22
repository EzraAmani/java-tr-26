package Excercises.javase020.Stduentgradeprocessor;

// Course.java
class Course {
    String code;
    String name;
    int credits;
    String department;

    Course(String code, String name, int credits, String department) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return code + ": " + name + " (" + credits + " credits)";
    }
}