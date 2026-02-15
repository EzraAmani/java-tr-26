package Excercises.javase019.functionalinterfaces;

@FunctionalInterface
interface Validator {
    boolean validate(String input);
}