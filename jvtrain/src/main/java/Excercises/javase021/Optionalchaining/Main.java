package Excercises.javase021.Optionalchaining;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // --- SCENARIO 1: Person has all info ---
        Person person1 = new Person(
                new Address(
                        new City("Paris")));

        // SCENARIO 2: Person exists but has no address
        Person person2 = new Person(null);

        // SCENARIO 3: No person at all
        Person person3 = null;

        // Let's safely get the city names!
        getCityName(person1); // Has everything
        getCityName(person2); // Missing address
        getCityName(person3); // Missing person

        // --- Java 9+ FEATURE: ifPresentOrElse ---
        System.out.println("\n--- Java 9+ Feature ---");
        Optional<String> maybeCity = Optional.of("London");

        // Instead of if-else, do this:
        maybeCity.ifPresentOrElse(
                city -> System.out.println("City is: " + city),
                () -> System.out.println("No city found!"));

        // --- Java 9+ FEATURE: or ---
        Optional<String> empty = Optional.empty();
        String result = empty
                .or(() -> Optional.of("Default City"))
                .get();
        System.out.println("Result with default: " + result);
    }

    // The magic method that safely navigates through everything!
    public static void getCityName(Person person) {
        System.out.println("\nLooking for city...");

        String cityName = Optional.ofNullable(person) // Maybe person is null
                .map(p -> p.address) // Get address if exists
                .map(addr -> addr.city) // Get city if exists
                .map(c -> c.name) // Get city name if exists
                .orElse("Unknown City"); // Default if anything is null

        System.out.println("City found: " + cityName);
    }
}

// --- Our simple data classes ---
class Person {
    Address address;

    Person(Address address) {
        this.address = address;
    }
}

class Address {
    City city;

    Address(City city) {
        this.city = city;
    }
}

class City {
    String name;

    City(String name) {
        this.name = name;
    }
}