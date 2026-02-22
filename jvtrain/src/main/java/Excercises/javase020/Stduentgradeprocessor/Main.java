package Excercises.javase020.Stduentgradeprocessor;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Create sample data
        List<Student> students = createStudents();
        List<Course> courses = createCourses();

        System.out.println("=== STUDENT GRADE PROCESSING SYSTEM ===\n");

        // 1. LAZY EVALUATION DEMO - FIXED
        System.out.println("1. LAZY EVALUATION DEMO:");
        System.out.println("   (Operations only execute when terminal operation is called)");

        // FIXED: Properly typed stream
        Stream<Student> studentStream = students.stream()
                .filter(s -> {
                    System.out.println("   Filtering: " + s.name);
                    return s.gpa > 3.0;
                });

        System.out.println("   Stream created but NOTHING executed yet...\n");
        System.out.println("   Now calling terminal operation (count):");
        long count = studentStream.count();
        System.out.println("   Result: " + count + " students with GPA > 3.0\n");

        // 2. COMPLEX FILTERING AND MAPPING
        System.out.println("2. FILTERING AND MAPPING:");

        List<String> honorStudents = students.stream()
                .filter(s -> s.gpa >= 3.5) // Honor roll
                .filter(s -> s.courses.size() >= 3) // Taking at least 3 courses
                .map(s -> s.name + " (GPA: " + s.gpa + ")")
                .collect(Collectors.toList());

        System.out.println("   Honor Students (GPA ≥ 3.5, ≥3 courses):");
        honorStudents.forEach(s -> System.out.println("   - " + s));
        System.out.println();

        // 3. HANDLE EMPTY STREAMS
        System.out.println("3. HANDLING EMPTY STREAMS:");

        List<Student> emptyList = new ArrayList<>();

        // Safe way to handle empty streams
        double averageGpa = emptyList.stream()
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0.0); // Default value if empty

        System.out.println("   Average GPA of empty list: " + averageGpa);

        // Using Optional for safe operations
        Optional<Student> topStudent = students.stream()
                .filter(s -> s.gpa > 4.0) // No student has GPA > 4.0
                .findFirst();

        System.out.println("   Student with GPA > 4.0: " +
                topStudent.map(s -> s.name).orElse("None found"));
        System.out.println();

        // 4. ADVANCED GROUPING AND STATISTICS
        System.out.println("4. GROUPING AND STATISTICS:");

        // Group by grade level and calculate statistics
        Map<String, DoubleSummaryStatistics> statsByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.grade,
                        Collectors.summarizingDouble(s -> s.gpa)));

        System.out.println("   GPA Statistics by Grade Level:");
        statsByGrade.forEach((grade, stats) -> {
            System.out.println("   " + grade + ":");
            System.out.println("     Count: " + stats.getCount());
            System.out.println("     Avg GPA: " + String.format("%.2f", stats.getAverage()));
            System.out.println("     Min GPA: " + stats.getMin());
            System.out.println("     Max GPA: " + stats.getMax());
        });
        System.out.println();

        // 5. FLATMAP FOR NESTED DATA
        System.out.println("5. ANALYZING COURSE ENROLLMENT:");

        // Get all unique courses across all students
        List<String> allCourses = students.stream()
                .flatMap(s -> s.courses.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("   All unique courses taken: " + allCourses);

        // Find most popular courses
        Map<String, Long> coursePopularity = students.stream()
                .flatMap(s -> s.courses.stream())
                .collect(Collectors.groupingBy(
                        course -> course,
                        Collectors.counting()));

        System.out.println("   Course popularity:");
        coursePopularity.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println("     " + e.getKey() + ": " + e.getValue() + " students"));
        System.out.println();

        // 6. COMPLEX REDUCTION
        System.out.println("6. COMPLEX REDUCTION OPERATIONS:");

        // Find student with highest GPA in each grade
        Map<String, Optional<Student>> topByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.grade,
                        Collectors.maxBy(Comparator.comparingDouble(s -> s.gpa))));

        System.out.println("   Top student by grade level:");
        topByGrade.forEach((grade, student) -> System.out.println("   " + grade + ": " +
                student.map(s -> s.name + " (GPA: " + s.gpa + ")")
                        .orElse("None")));
        System.out.println();

        // 7. PARALLEL PROCESSING DEMO
        System.out.println("7. SEQUENTIAL VS PARALLEL PROCESSING:");

        // Sequential processing
        long startTime = System.nanoTime();
        double sequentialAvg = students.stream()
                .filter(s -> s.gpa > 3.0)
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0.0);
        long sequentialTime = System.nanoTime() - startTime;

        // Parallel processing
        startTime = System.nanoTime();
        double parallelAvg = students.parallelStream()
                .filter(s -> s.gpa > 3.0)
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0.0);
        long parallelTime = System.nanoTime() - startTime;

        System.out.println("   Sequential average GPA (>3.0): " +
                String.format("%.2f", sequentialAvg) +
                " (Time: " + sequentialTime / 1000000 + " ms)");
        System.out.println("   Parallel average GPA (>3.0): " +
                String.format("%.2f", parallelAvg) +
                " (Time: " + parallelTime / 1000000 + " ms)");
        System.out.println();
    }

    // Data creation methods
    private static List<Student> createStudents() {
        return Arrays.asList(
                new Student(1, "Alice Johnson", "Senior", 3.8,
                        Arrays.asList("MATH101", "CS201", "PHYS101")),
                new Student(2, "Bob Smith", "Junior", 3.2,
                        Arrays.asList("CS201", "ENGL101", "MATH201")),
                new Student(3, "Charlie Brown", "Senior", 3.9,
                        Arrays.asList("CS301", "MATH301", "PHYS201", "CS201")),
                new Student(4, "Diana Prince", "Sophomore", 3.5,
                        Arrays.asList("MATH101", "ENGL101", "HIST101")),
                new Student(5, "Eve Wilson", "Freshman", 2.8,
                        Arrays.asList("MATH101", "ENGL101")),
                new Student(6, "Frank Castle", "Junior", 3.1,
                        Arrays.asList("CS201", "MATH201", "PHYS101")),
                new Student(7, "Grace Lee", "Senior", 4.0,
                        Arrays.asList("CS301", "MATH401", "PHYS301", "CS401")),
                new Student(8, "Henry Ford", "Sophomore", 2.9,
                        Arrays.asList("ECON101", "MATH101", "ENGL101")),
                new Student(9, "Ivy Chen", "Freshman", 3.7,
                        Arrays.asList("MATH101", "CS101", "ENGL101")),
                new Student(10, "Jack Ryan", "Junior", 3.4,
                        Arrays.asList("CS201", "MATH201", "HIST201")));
    }

    private static List<Course> createCourses() {
        return Arrays.asList(
                new Course("CS101", "Intro to Programming", 3, "CS"),
                new Course("CS201", "Data Structures", 4, "CS"),
                new Course("CS301", "Algorithms", 4, "CS"),
                new Course("CS401", "Machine Learning", 3, "CS"),
                new Course("MATH101", "Calculus I", 3, "Math"),
                new Course("MATH201", "Calculus II", 3, "Math"),
                new Course("MATH301", "Linear Algebra", 3, "Math"),
                new Course("MATH401", "Differential Equations", 4, "Math"),
                new Course("PHYS101", "Physics I", 4, "Physics"),
                new Course("PHYS201", "Physics II", 4, "Physics"),
                new Course("PHYS301", "Modern Physics", 3, "Physics"),
                new Course("ENGL101", "English Composition", 3, "English"),
                new Course("HIST101", "World History", 3, "History"),
                new Course("HIST201", "US History", 3, "History"),
                new Course("ECON101", "Economics", 3, "Business"));
    }
}