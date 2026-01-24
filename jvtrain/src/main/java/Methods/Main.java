package Methods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // calculateArea(5.0);
        // System.out.println(area(3, 5));
        // tocelsius(100);
        highest(19, 14, 3, 92);

    }

    public static void calculateArea(double radius) {
        double area = 3.14159 * radius * radius;
        System.out.println("Area: " + area);
    }

    public static int area(int l, int w) {
        int ar = l * w;
        return ar;
    }

    public static void areafull(int l, int w) {
        int ar = l * w;
        System.out.println(ar);
    }

    public static void tocelsius(int f) {
        int c = (f - 32) * 5 / 9;
        System.out.println(f + "  to celsius is " + c);
    }

    public static void highest(int a, int b, int c, int d) {
        int[] numbers = { a, b, c, d };
        int highest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }
        }

        System.out.println("Highest number is " + highest);

    }

}
