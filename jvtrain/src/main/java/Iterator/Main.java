package Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("English", "0002", 2015, "John Makasy"));
        books.add(new Book("Kiswahili", "0003", 2016, "Roy Fabisky"));
        books.add(new Book("Social Studies", "0004", 2016, "Pamela White"));

        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // iterator.remove();
        }
        // System.out.println("\n\nprocessing by list iterator\n");

        // ListIterator<Book> listIterator = books.listIterator(3);
        // while (listIterator.hasPrevious()) {

        // System.out.println(listIterator.previous());
        // System.out.println(listIterator.previousIndex());

        // }
        System.out.println("Before sorting");
        System.out.println(books);

        Collections.sort(books);
        System.out.println(books);
    }

}
