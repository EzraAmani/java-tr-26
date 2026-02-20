package Excercises.javase015.Inventory;

import java.util.*;

public class InventoryManager {
    List<Product> products; // Can be ArrayList or LinkedList

    // Constructor - choose which type to use
    public InventoryManager(String type) {
        if (type.equals("arraylist")) {
            products = new ArrayList<>();
            System.out.println("Using ArrayList");
        } else {
            products = new LinkedList<>();
            System.out.println("Using LinkedList");
        }
    }

    // Add product
    void addProduct(Product p) {
        products.add(p);
        System.out.println("Added: " + p);
    }

    // Remove product by id
    void removeProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id == id) {
                Product removed = products.remove(i);
                System.out.println("Removed: " + removed);
                return;
            }
        }
        System.out.println("Product with id " + id + " not found");
    }

    // Find product by name
    void findProduct(String name) {
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + p);
                return;
            }
        }
        System.out.println("Product '" + name + "' not found");
    }

    // Update stock
    void updateStock(int id, int newQuantity) {
        for (Product p : products) {
            if (p.id == id) {
                p.quantity = newQuantity;
                System.out.println("Updated stock for: " + p);
                return;
            }
        }
        System.out.println("Product with id " + id + " not found");
    }

    // Sort by price
    void sortByPrice() {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).price > products.get(j + 1).price) {
                    // Swap
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted by price:");
        displayAll();
    }

    // Sort by name
    void sortByName() {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = 0; j < products.size() - i - 1; j++) {
                if (products.get(j).name.compareTo(products.get(j + 1).name) > 0) {
                    // Swap
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted by name:");
        displayAll();
    }

    // Display all products
    void displayAll() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory");
        } else {
            for (Product p : products) {
                System.out.println("  " + p);
            }
        }
    }

    // Search by price range
    void searchByPrice(double min, double max) {
        System.out.println("Products between $" + min + " and $" + max + ":");
        boolean found = false;
        for (Product p : products) {
            if (p.price >= min && p.price <= max) {
                System.out.println("  " + p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No products found in this price range");
        }
    }
}