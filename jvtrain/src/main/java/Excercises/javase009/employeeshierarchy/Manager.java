package Excercises.javase009.employeeshierarchy;

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is managing a team of " + teamSize + " people.");
    }
}
