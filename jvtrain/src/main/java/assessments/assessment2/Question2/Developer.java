package assessments.assessment2.Question2;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguage == null || programmingLanguage.trim().isEmpty()) {
            throw new IllegalArgumentException("Programming language cannot be empty");
        }
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
