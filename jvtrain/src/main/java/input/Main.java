package input;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name please: ");
        String name = scanner.nextLine();
        System.out.println("hi: " + name);

    }
}
