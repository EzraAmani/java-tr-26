package Excercises.javase015.Inventory;

public class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=$" + price + ", qty=" + quantity + "}";
    }
}