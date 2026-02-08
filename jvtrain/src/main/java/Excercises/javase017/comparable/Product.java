package Excercises.javase017.comparable;

class Product implements Comparable<Product> {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        // First compare by category
        int categoryCompare = this.category.compareTo(other.category);
        if (categoryCompare != 0)
            return categoryCompare;

        // If categories are equal, compare by price
        int priceCompare = Double.compare(this.price, other.price);
        if (priceCompare != 0)
            return priceCompare;

        // If prices are equal, compare by name
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return category + " - " + name + " ($" + price + ")";
    }
}