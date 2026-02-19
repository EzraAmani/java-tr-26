package Nullsafety;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

public class PetStore {

    // A list of pets in our store
    private List<String> pets = Arrays.asList("Dog", "Cat", "Fish", "Hamster");

    // ===== PART 1: Creating Optionals in different ways =====

    // Method 1: Optional.of() - WHEN YOU KNOW the value is NOT null
    public Optional<String> createPetWithValue() {
        String pet = "Dragon";
        return Optional.of(pet); // Will throw NPE if pet is null!
    }

    // Method 2: Optional.ofNullable() - WHEN YOU'RE NOT SURE if value might be null
    public Optional<String> createPetSafely(String pet) {
        return Optional.ofNullable(pet); // Safe! Accepts null
    }

    // Method 3: Optional.empty() - CREATE an empty Optional on purpose
    public Optional<String> createEmptyPet() {
        return Optional.empty(); // An empty box
    }

    // ===== PART 2: Safe value retrieval with defaults =====

    // Find a pet by name
    public Optional<String> findPet(String petName) {
        if (pets.contains(petName)) {
            return Optional.of(petName);
        } else {
            return Optional.empty();
        }
    }

    // Get pet with a default if not found
    public String getPetWithDefault(String petName) {
        Optional<String> foundPet = findPet(petName);

        // Different ways to provide defaults:

        // 1. orElse() - ALWAYS computes the default value
        String result1 = foundPet.orElse("No pet found, here's a default Hamster");

        // 2. orElseGet() - ONLY computes the default if needed (lazy)
        String result2 = foundPet.orElseGet(() -> {
            System.out.println("⚠️ Pet not found, creating default...");
            return "Default Hamster";
        });

        // 3. orElseThrow() - Throw exception if empty
        // String result3 = foundPet.orElseThrow(() -> new RuntimeException("No pet!"));

        return result2;
    }

    // ===== PART 3: Conditional operations with ifPresent =====

    public void playWithPet(String petName) {
        Optional<String> pet = findPet(petName);

        // ifPresent - do something ONLY if pet exists
        pet.ifPresent(p -> {
            System.out.println("🎾 Playing with: " + p);
            System.out.println("🐕 " + p + " is happy!");
        });

        // ifPresentOrElse (Java 9+) - do something if present OR if empty
        pet.ifPresentOrElse(
                p -> System.out.println("🎮 Playing fetch with " + p),
                () -> System.out.println("😢 No pet to play with... *sad noises*"));
    }

    // ===== PART 4: Convert nullable methods to Optional =====

    // OLD, DANGEROUS way (returns null!)
    public String findPetOldWay(String petName) {
        return pets.contains(petName) ? petName : null;
    }

    // NEW, SAFE way - converts the old nullable method to Optional
    public Optional<String> findPetNewWay(String petName) {
        // Converting nullable result to Optional
        String result = findPetOldWay(petName);
        return Optional.ofNullable(result); // Null becomes empty Optional!
    }

    // ===== PART 5: Handle empty Optional scenarios =====

    public void petStoreExperience(String petName) {
        System.out.println("\n🔍 Customer wants: " + petName);

        Optional<String> pet = findPet(petName);

        // Check if pet exists the safe way
        if (pet.isPresent()) {
            System.out.println("✅ We have " + pet.get() + " in stock!");
        } else {
            System.out.println("❌ Sorry, no " + petName + " today");
        }

        // More elegant way with ifPresent
        pet.ifPresentOrElse(
                p -> {
                    System.out.println("💰 Price of " + p + ": $50");
                    System.out.println("📦 Would you like to buy " + p + "?");
                },
                () -> {
                    System.out.println("📋 Would you like to order a " + petName + "?");
                    System.out.println("⏰ Delivery takes 3 days");
                });

        // Filtering - only certain pets can do tricks
        pet.filter(p -> p.equals("Dog") || p.equals("Cat"))
                .ifPresent(p -> System.out.println("🎪 " + p + " can do tricks!"));
    }

    // ===== BONUS: Chaining Optional operations =====

    public void optionalChainingDemo() {
        System.out.println("\n=== OPTIONAL CHAINING DEMO ===");

        // Chain operations!
        String result = findPet("Dog")
                .map(p -> p.toUpperCase()) // Transform
                .filter(p -> p.length() > 3) // Filter
                .orElse("UNKNOWN"); // Default

        System.out.println("Chained result: " + result);

        // FlatMap - when your mapping returns another Optional
        Optional<String> flatMapped = findPet("Cat")
                .flatMap(this::findPet); // Finds Cat, then uses it to find another pet

        System.out.println("FlatMap result: " + flatMapped.orElse("No pet"));
    }

    // ===== MAIN METHOD to test everything =====
    public static void main(String[] args) {
        PetStore store = new PetStore();

        System.out.println("🎪 WELCOME TO THE PET STORE! 🎪\n");

        // 1. Creating Optionals
        System.out.println("=== CREATING OPTIONALS ===");
        System.out.println("Optional.of(): " + store.createPetWithValue());
        System.out.println("Optional.ofNullable(null): " + store.createPetSafely(null));
        System.out.println("Optional.empty(): " + store.createEmptyPet());

        // 2. Safe retrieval with defaults
        System.out.println("\n=== SAFE RETRIEVAL ===");
        System.out.println("Find Dog: " + store.getPetWithDefault("Dog"));
        System.out.println("Find Dinosaur: " + store.getPetWithDefault("Dinosaur"));

        // 3. Conditional operations
        System.out.println("\n=== CONDITIONAL OPERATIONS ===");
        store.playWithPet("Cat");
        store.playWithPet("Dinosaur");

        // 4. Converting nullable methods
        System.out.println("\n=== CONVERTING NULLABLE METHODS ===");
        System.out.println("Old way (might be null): " + store.findPetOldWay("Fish"));
        System.out.println("Old way (null!): " + store.findPetOldWay("Bird")); // Returns null!
        System.out.println("New way (Optional): " + store.findPetNewWay("Bird")); // Returns empty Optional

        // 5. Handling empty scenarios
        System.out.println("\n=== HANDLING EMPTY SCENARIOS ===");
        store.petStoreExperience("Hamster");
        store.petStoreExperience("Unicorn");

        // 6. BONUS: Chaining
        store.optionalChainingDemo();

        // 7. EXTRA: Different ways to get values
        System.out.println("\n=== DIFFERENT WAYS TO GET VALUES ===");
        Optional<String> optionalDog = store.findPet("Dog");

        // orElse
        System.out.println("orElse: " + optionalDog.orElse("Default"));

        // orElseGet (lazy)
        System.out.println("orElseGet: " + optionalDog.orElseGet(() -> {
            System.out.println("  (This only prints if empty!)");
            return "Default";
        }));

        // or (Java 9+) - returns another Optional if empty
        Optional<String> orResult = optionalDog.or(() -> Optional.of("Backup Pet"));
        System.out.println("or(): " + orResult.get());

        // ifPresent
        optionalDog.ifPresent(p -> System.out.println("Found via ifPresent: " + p));

        System.out.println("\n🏁 Thanks for visiting the pet store! 🏁");
    }
}
