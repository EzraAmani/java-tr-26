package multiple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter tha value you wish to know the multiplication of please: ");
        int j = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(j + " x " + i + " = " + (j * i));
        }
        scanner.close();
    }

}
