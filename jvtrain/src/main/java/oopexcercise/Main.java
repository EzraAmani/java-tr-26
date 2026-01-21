package oopexcercise;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World");
        User u = new User();
        u.set_name("Caleb");
        u.membership = "Gold";

        System.out.println(u.get_name());

    }
}
