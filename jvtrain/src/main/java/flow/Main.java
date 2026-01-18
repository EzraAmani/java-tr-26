package flow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age please: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age >= 18 && age <= 30) {
            System.out.println("You are a youth");
        } else if (age > 30) {
            System.out.println("You are old");
        } else {
            System.out.println("You are a child");
        }
        scanner.close();
    }

}
