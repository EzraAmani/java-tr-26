package Excercises.javase003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Please enter your height: ");
        double height = scanner.nextDouble();

        double bmi = weight / (height * height);

        if (bmi < 18.5) {
            System.out.println("Your bmi is " + bmi + " and are underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Your bmi is " + bmi + " and are of normal weight");
        } else if (bmi >= 25.0 && bmi < 29.9) {
            System.out.println("Your bmi is " + bmi + " and are overweight");
        }
        scanner.close();

    }

}

class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean showMenu = true;
        while (showMenu == true) {
            System.out.println("==========Ezra and Ezra==========");
            System.out.println("1.Tea \n 2.Maandazi \n 3.Chapati \n 4.Exit");
            System.out.println("==========Ezra and Ezra==========");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your tea is coming ");
                    break;
                case 2:
                    System.out.println("Your maandazi is coming ");
                    break;
                case 3:
                    System.out.println("Your chapati is coming ");
                    break;
                case 4:
                    showMenu = false;
                    break;
                case 5:
                    System.out.println("Invalid entry");
                    break;

            }

        }
        scanner.close();
    }
}