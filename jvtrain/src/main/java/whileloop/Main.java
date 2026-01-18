package whileloop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String password = "secret123";
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        while (!userInput.equals(password)) {
            System.out.print("Enter password: ");
            userInput = scanner.nextLine();
            if (!userInput.equals(password)) {
                System.out.println("Incorrect! Try again.");
            }
        }
        System.out.println("Access granted!");
        scanner.close();

    }
}
