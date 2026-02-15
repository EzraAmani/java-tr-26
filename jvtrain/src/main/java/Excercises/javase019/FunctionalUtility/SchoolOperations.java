package Excercises.javase019.FunctionalUtility;

import java.util.*;
import java.util.function.*;

class SchoolOperations {

    // Combine multiple operations in one pipeline
    public static void honorRollCeremony(List<Student> students) {
        System.out.println("\n🎓 HONOR ROLL CEREMONY 🎓");

        // 1. FILTER: Get honor roll students
        List<Student> honorRoll = StudentFilter.filterStudents(students,
                s -> s.getGpa() >= 3.5);

        // 2. TRANSFORM: Get their names (store in List<String>)
        List<String> honorNames = StudentTransformer.transformStudents(honorRoll,
                Student::getName); // Method reference! - Returns List<String>

        // 3. PROCESS: Announce each one
        System.out.println("Honor Roll Students:");
        StudentProcessor.processStudents(honorRoll,
                s -> System.out.println("  🏆 " + s.getName() + " (GPA: " + s.getGpa() + ")"));

        // 4. GENERATE: Create certificates (FIXED: Store in List<Student>, not
        // List<String>)
        List<Student> certificates = StudentGenerator.generateStudents(
                () -> new Student("Certificate", 0, 0), // Dummy student
                honorRoll.size());

        System.out.println("\n" + honorNames.size() + " students honored!");
    }

    // Another combined operation
    public static void studySession(List<Student> students) {
        System.out.println("\n📖 STUDY SESSION 📖");

        // Filter students who need to study (GPA < 3.0)
        List<Student> needHelp = StudentFilter.filterStudents(students,
                s -> s.getGpa() < 3.0);

        // Make them study
        StudentProcessor.processStudents(needHelp,
                Student::study); // Method reference!

        // Transform to names for reporting
        List<String> helpedNames = StudentTransformer.transformStudents(needHelp,
                Student::getName); // Method reference!

        System.out.println("Helped students: " + helpedNames);
    }

    // Advanced combined operation
    public static void gradeLevelReport(List<Student> students, int targetGrade) {
        System.out.println("\n📊 GRADE " + targetGrade + " REPORT 📊");

        // Chain operations together
        Predicate<Student> gradeFilter = s -> s.getGrade() == targetGrade;
        Function<Student, String> nameTransformer = Student::getName;
        Consumer<String> printer = System.out::println; // Method reference!

        // Filter
        List<Student> gradeStudents = StudentFilter.filterStudents(students, gradeFilter);

        // Transform to names
        List<String> names = StudentTransformer.transformStudents(gradeStudents, nameTransformer);

        // Process (print)
        System.out.println("Students in grade " + targetGrade + ":");
        names.forEach(printer);

        // Calculate average GPA for this grade
        List<Double> gpas = StudentTransformer.transformStudents(gradeStudents, Student::getGpa);
        double avg = gpas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("Average GPA: " + Math.round(avg * 100) / 100.0);
    }

    // BONUS: Another combined operation
    public static void principalList(List<Student> students) {
        System.out.println("\n👨‍🏫 PRINCIPAL'S LIST 👨‍🏫");

        // Filter students with GPA 4.0
        List<Student> perfectGpa = StudentFilter.filterStudents(students,
                s -> s.getGpa() == 4.0);

        // Transform to names with stars
        List<String> starStudents = StudentTransformer.transformStudents(perfectGpa,
                s -> "⭐ " + s.getName() + " ⭐");

        // Print them
        StudentProcessor.processStudents(perfectGpa,
                StudentProcessor.printStudent());

        System.out.println("Perfect GPA students: " + perfectGpa.size());
    }
}