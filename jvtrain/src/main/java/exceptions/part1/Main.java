package exceptions.part1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your age: ");
            int age = scanner.nextInt();
            if (age >= 18) {
                System.out.println("You can apply for ID");
            } else {
                System.out.println("You are still a minor");
            }

        } catch (InputMismatchException exception) {

            System.out.println("exception happened");

        }

    }

}
