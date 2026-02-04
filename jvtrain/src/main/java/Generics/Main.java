package Generics;

public class Main {
    public static void main(String[] args) {
        printer<Integer> printer = new printer<>(13);
        printer<String> printer2 = new printer<>("Hello Generics");
        Pair<String, String> pair1 = new Pair<>("Moonwalk", "Dance");

        // printer.print();
        // printer2.print();

        pair1.setKey("Love");

        System.out.println(pair1.createList("apples", "mangoes"));

    }
}
