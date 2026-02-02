package Generics;

public class Main {
    public static void main(String[] args) {
        printer<Integer> printer = new printer<>(13);

        printer.print();
    }
}
