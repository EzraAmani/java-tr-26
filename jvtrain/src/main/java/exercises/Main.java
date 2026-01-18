package exercises;

import java.util.Random;

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
