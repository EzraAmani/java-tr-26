package mainexercises;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(message());
    }

    public static String message() {
        String status = "Pending";
        return status.equals("Pending") ? "Your order is pending" : "Your order is complete";
        // return status == "Pending" ? "Your order is pending" : "Your order is
        // complete";
    }

}

class random {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}

class Forloop {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("the flash");
        }
    }
}

class While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean showMenu = true;
        while (showMenu == true) {
            System.out.println("==========Ezra and Ezra==========");
            System.out.println("Tea");
            System.out.println("Maandazi");
            System.out.println("Chapati");
            System.out.println("==========Ezra and Ezra==========");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            if (choice == 4) {
                showMenu = false;
            } else {
                System.out.println("You have been served with." + choice);
            }

        }
        scanner.close();
    }
}
