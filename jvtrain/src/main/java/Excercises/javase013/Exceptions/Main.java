package Excercises.javase013.Exceptions;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            createStudent("John", "001", "CS");
        } catch (StudentAlreadyExistsException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static void createStudent(String name, String regNo, String course) throws StudentAlreadyExistsException {
        Set<String> names = new HashSet<>();
        names.addAll(Set.of("John", "Mhusik", "Joy", "livingstone"));
        if (name.contains(name)) {
            throw new StudentAlreadyExistsException("Student with name " + name + " already exists");
        }

    }

}
