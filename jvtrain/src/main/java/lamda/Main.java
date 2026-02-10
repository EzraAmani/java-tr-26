package lamda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // getPrinterInLamda();
        commonBuiltInFunctionalInterfaces();

    }

    private static void functions() {
        Function<String, Integer> function = t -> t.trim().length();

        List<String> myListOfStrings = List.of("I love java programming", "java is cool", "MyPassword");

        for (String string : myListOfStrings) {
            System.out.println(string + "has trimmed length -> " + function.apply(string));
        }

    }

    private static void commonBuiltInFunctionalInterfaces() {
        System.out.println("======functions=======");
        functions();
    }

    private static void getPrinterInLamda() {
        Export pdfExport = new PdfExport();
        pdfExport.export("I have learnt interesting topics");

        Export powerPoint = new PptExport();
        powerPoint.export("I am becoming.....");

        // anonymous implementation

        Export htmlExport = new Export() {
            public void export(String content) {
                System.out.println("Exporting to HTML " + content);

            }

        };

        htmlExport.export("Java is awesome though challenging");

        Export pngExport = (content) -> System.out.println("Exporting to HTML " + content);
        pngExport.export("This is an awesome image");

        Printer printerInLamda = (content, path) -> {

            System.out.println("Printing " + content + " to " + path);
            return "success";

        };

        printerInLamda.print("love", "flash");
    }

    private static void predicates() {

        // Predicate<Integer> isEvenPredicate = (Integer t) -> {
        // // t % 2 == 0;

        // boolean isEven = false;
        // if (t % 2 == 0) {
        // isEven = true;
        // }
        // return isEven;

        // };

        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        };

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        for (Integer num : numbers) {
            System.out.println(num + " is even -> " + isEvenPredicate.test(num));
        }

    }

}
