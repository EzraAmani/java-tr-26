package Excercises.javase009.employeeshierarchy;

class Intern extends Employee {
    private int durationMonths;

    public Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is interning for " + durationMonths + " months.");
    }
}