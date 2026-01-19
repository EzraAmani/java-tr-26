package assessment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // problem1();
        // problem2();
        // problem3();
        problem4();

    }

    public static void problem1() {
        int a = 15;
        int b = 4;
        int c = 7;

        int sum = a + b + c;
        int product = a * b;
        int d = (a + b) * c;
        int e = a % b;

        System.out.println("The sum of all 3 numbers is " + sum + " \nThe product of a and b is " + product
                + "\n(a + b) * c is " + d + "\nThe remainder of a divided by b is " + e);

    }

    public static void problem2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your score: ");
        int score = scanner.nextInt();
        if (score >= 90 && score <= 100) {
            System.out.println("Grade: A");
        } else if (score >= 80 && score <= 89) {
            System.out.println("Grade: B");
        } else if (score >= 70 && score <= 79) {
            System.out.println("Grade: C");
        } else if (score >= 60 && score <= 69) {
            System.out.println("Grade: D");
        } else if (score < 69) {
            System.out.println("Grade: F");
        } else {
            System.out.println("Error: Score must be between 0 and 100");
        }
        scanner.close();

    }

    public static void problem3() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " Even");
                if (i % 5 == 0) {
                    System.out.println("Multiple of 5");
                }
            } else if (i % 2 != 0) {
                System.out.println(i + " Odd");
                if (i % 5 == 0) {
                    System.out.println("Multiple of 5");
                }
            }
        }
    }

    public static void problem4() {
        Scanner scanner = new Scanner(System.in);

        boolean status = true;
        while (status) {
            System.out.println("Please enter a positive integer: ");
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Invalid input! Please enter a positive integer");
            } else {
                int factorial = 1;

                for (int i = 1; i <= number; i++) {
                    factorial = factorial * i;

                }
                System.out.println("Factorial of " + number + " is " + factorial);
                status = false;

            }

        }

        scanner.close();

    }

}
