package Excercises.javase013.GradeSystem;

class Student {
    private String name;
    private int grade;

    public Student(String name) {
        this.name = name;
        this.grade = 0; // default grade
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Grade must be between 0 and 100");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}
