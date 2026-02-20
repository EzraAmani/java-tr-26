package Excercises.javase015.Inventory;

public class Main {
    public static void main(String[] args) {
        // Test with ArrayList
        System.out.println("=== TESTING WITH ARRAYLIST ===");
        InventoryManager manager1 = new InventoryManager("arraylist");
        testInventory(manager1);

        System.out.println("\n\n=== TESTING WITH LINKEDLIST ===");
        // Test with LinkedList
        InventoryManager manager2 = new InventoryManager("linkedlist");
        testInventory(manager2);
    }

    static void testInventory(InventoryManager manager) {
        // Add products
        manager.addProduct(new Product(101, "Laptop", 899.99, 5));
        manager.addProduct(new Product(102, "Mouse", 24.99, 20));
        manager.addProduct(new Product(103, "Keyboard", 49.99, 10));
        manager.addProduct(new Product(104, "Monitor", 249.99, 3));

        System.out.println();

        // Display all
        System.out.println("All products:");
        manager.displayAll();

        System.out.println();

        // Find product
        manager.findProduct("Mouse");
        manager.findProduct("Tablet");

        System.out.println();

        // Update stock
        manager.updateStock(101, 3);

        System.out.println();

        // Search by price
        manager.searchByPrice(20, 100);

        System.out.println();

        // Sort by price
        manager.sortByPrice();

        System.out.println();

        // Sort by name
        manager.sortByName();

        System.out.println();

        // Remove product
        manager.removeProduct(102);

        System.out.println();

        // Display after removal
        System.out.println("After removal:");
        manager.displayAll();
    }
}