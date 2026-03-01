package revision;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        // Now iterator.remove() works
        // System.out.println("\n=== Iterator with Removal ===");
        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            String color = iterator.next();
            // System.out.println("Color: " + color);
            if (color.equals("Green")) {
                iterator.remove(); // Safe removal
            }
        }

        // System.out.println("After removal: " + colors);

        Student stud1 = new Student(null, 0, 0);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 21, 3.9));
        students.add(new Student("Alice", 20, 3.8));
        students.add(new Student("Bob", 22, 3.5));

        Collections.sort(students);

        // students.forEach(student -> System.out.println(student));

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Writing to a string");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
