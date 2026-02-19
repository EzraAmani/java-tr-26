package Nullsafety;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.processNickname("Hello"); // This is fine
        userService.findNicknameOrNull("user123");
        // The following line would cause a compile-time error due to null safety:
        // userService.processNickname(null); // Uncommenting this will cause an error

        Optional<String> puppy = findPuppy("Fluffy");
        System.out.println(puppy.orElse("No puppy"));

    }

    public static Optional<String> findPuppy(String name) {
        if (name.equals("Fluffy")) {
            return Optional.of("Fluffy the puppy"); // Box with puppy
        } else {
            return Optional.empty(); // Empty box, but STILL A BOX!
        }
    }

}