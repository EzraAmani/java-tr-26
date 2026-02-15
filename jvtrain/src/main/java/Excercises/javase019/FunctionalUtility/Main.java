package Excercises.javase019.FunctionalUtility;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Create some students
        List<Student> students = Arrays.asList(
                new Student("Alice", 9, 3.8),
                new Student("Bob", 10, 2.5),
                new Student("Charlie", 9, 3.2),
                new Student("Diana", 11, 4.0),
                new Student("Eve", 10, 2.1),
                new Student("Frank", 12, 3.6));

        System.out.println("🎒 WELCOME TO SCHOOL MANAGEMENT SYSTEM 🎒");
        System.out.println("=========================================");

        // ===========================================
        // 1. TEST FILTER (Predicate)
        // ===========================================
        System.out.println("\n🔍 FILTERING STUDENTS:");

        List<Student> honorRoll = StudentFilter.filterStudents(students,
                s -> s.getGpa() >= 3.5);
        System.out.println("Honor Roll: " + honorRoll);

        List<Student> ninthGraders = StudentFilter.filterStudents(students,
                StudentFilter.ninthGraders()); // Using pre-defined filter
        System.out.println("Ninth Graders: " + ninthGraders);

        List<Student> nameWithA = StudentFilter.filterStudents(students,
                StudentFilter.nameStartsWith("A")); // Using pre-defined filter
        System.out.println("Names starting with A: " + nameWithA);

        // ===========================================
        // 2. TEST TRANSFORM (Function)
        // ===========================================
        System.out.println("\n🔄 TRANSFORMING STUDENTS:");

        List<String> names = StudentTransformer.transformStudents(students,
                StudentTransformer.toName()); // Method reference through helper
        System.out.println("All names: " + names);

        List<Double> gpas = StudentTransformer.transformStudents(students,
                Student::getGpa); // Direct method reference!
        System.out.println("All GPAs: " + gpas);

        List<String> cards = StudentTransformer.transformStudents(students,
                StudentTransformer.toStudentCard());
        System.out.println("Student cards:");
        cards.forEach(System.out::println);

        // ===========================================
        // 3. TEST PROCESS (Consumer)
        // ===========================================
        System.out.println("\n⚙️ PROCESSING STUDENTS:");

        System.out.println("Printing all students:");
        StudentProcessor.processStudents(students,
                StudentProcessor.printStudent()); // Method reference through helper

        System.out.println("\nMaking students study:");
        StudentProcessor.processStudents(students,
                Student::study); // Direct method reference!

        System.out.println("\nGiving bonus GPA to some students:");
        List<Student> someStudents = students.subList(0, 2);
        StudentProcessor.processStudents(someStudents,
                s -> s.setGpa(s.getGpa() + 0.5));
        System.out.println("After bonus: " + someStudents);

        // ===========================================
        // 4. TEST GENERATE (Supplier)
        // ===========================================
        System.out.println("\n🏭 GENERATING STUDENTS:");

        List<Student> newStudents = StudentGenerator.generateStudents(
                StudentGenerator.defaultStudent(), 3);
        System.out.println("Default students: " + newStudents);

        List<Student> randomStudents = StudentGenerator.generateStudents(
                StudentGenerator.randomStudent(), 4);
        System.out.println("Random students: " + randomStudents);

        List<Student> honors = StudentGenerator.generateStudents(
                StudentGenerator.honorStudent(), 2);
        System.out.println("Honor students: " + honors);

        // ===========================================
        // 5. TEST COMBINED OPERATIONS
        // ===========================================
        System.out.println("\n🎯 COMBINED OPERATIONS:");

        // Add random students to our list
        List<Student> allStudents = new ArrayList<>(students);
        allStudents.addAll(randomStudents);

        // Run combined operations
        SchoolOperations.honorRollCeremony(allStudents);
        SchoolOperations.studySession(allStudents);
        SchoolOperations.gradeLevelReport(allStudents, 10);

        // ===========================================
        // 6. BONUS: Method References Showcase
        // ===========================================
        System.out.println("\n🌟 METHOD REFERENCES SHOWCASE:");

        // Static method reference
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println("Parsed number: " + parser.apply("123"));

        // Instance method reference on specific object
        Student teacher = new Student("Ms. Smith", 0, 0);
        Runnable introduce = teacher::toString;
        System.out.println("Teacher: " + introduce);

        // Instance method reference on parameter
        List<String> words = Arrays.asList("hello", "world");
        // FIXED: Changed toList() to collect(Collectors.toList())
        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase: " + upper);

        // Constructor reference
        Supplier<ArrayList<Student>> listMaker = ArrayList::new;
        ArrayList<Student> newList = listMaker.get();
        System.out.println("New list created: " + newList);

        // Array constructor reference
        Function<Integer, Student[]> arrayMaker = Student[]::new;
        Student[] studentArray = arrayMaker.apply(5);
        System.out.println("Array size: " + studentArray.length);

        // BONUS: Another example with numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // FIXED: Changed toList() to collect(Collectors.toList())
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled numbers: " + doubled);
    }
}