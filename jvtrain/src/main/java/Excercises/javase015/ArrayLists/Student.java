package Excercises.javase015.ArrayLists;

public class Student {
    public int id;
    public String name;
    public String grade;

    public Student(int id, String name, String grade) {
        this.setId(id);
        this.setName(name);
        this.setGrade(grade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
    }

}
