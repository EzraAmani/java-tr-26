package Excercises.Javase007;

public class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;

    public Product() {
        this.productId = "Unknown";
        this.name = "Unnamed Product";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }

    public void addStock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println(amount + " units added. New quantity: " + quantity);
        } else {
            System.out.println("Invalid stock amount.");
        }
    }

    public void removeStock(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            System.out.println(amount + " units removed. New quantity: " + quantity);
        } else {
            System.out.println("Invalid amount or insufficient stock.");
        }
    }

    public double totalValue() {
        return price * quantity;
    }

    public void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Value: $" + totalValue());
    }
}
