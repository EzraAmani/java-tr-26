package OOP;

public class Student {

    public String name;
    public int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;

    }

    public void displayInfo() {
        System.out.println(name + "-" + age);
    }

}
