package Excercises.javase020.filteringandmapping;

// Product.java
class Product {
    String name;
    double price;
    int rating;

    Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    // Add these getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return name + "($" + price + ", rating:" + rating + ")";
    }
}