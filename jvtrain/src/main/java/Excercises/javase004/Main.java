package Excercises.javase004;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        numberguess();

    }

    public static void numberguess() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;

        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between " + lowerBound + " and " + upperBound);
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                guessedCorrectly = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess);
        }

        scanner.close();

    }

    public static void patternmaker() {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();

        }

    }

    public static void factorialcalculator() {
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
