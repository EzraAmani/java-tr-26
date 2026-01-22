package Excercises.javase006;

public class MathUtils {

    // This is if you want a random integer between min and max
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // If you want to check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // If you want to check if a number is odd
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    // I also added factorial calculator
    public static long factorial(int number) {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Find the maximum of two numbers
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Find the minimum of two numbers
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
