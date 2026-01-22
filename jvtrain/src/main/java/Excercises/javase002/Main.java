package Excercises.javase002;

public class Main {
    public static void main(String[] args) {
        String name = "Alice Johnson";
        int age = 20;
        int grade = 8;
        double gpa = 3.4;
        boolean Isgraduating = false;

        System.out.println("====Student Information==== \nName: " + name + "\nAge: " + age + " years\nGrade: " + grade
                + "\nGPA: " + gpa + "\nIs Graduating: " + Isgraduating);

        // To calculate bmi
        bmicalculator(1000, 10);
    }

    public static void bmicalculator(int mass, int height) {
        int bmi = mass / (height * height);
        System.out.println("Your bmi is: " + bmi);
    }

}
