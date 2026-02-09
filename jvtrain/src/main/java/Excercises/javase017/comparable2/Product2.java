package Excercises.javase017.comparable2;

class Product2 {
    String name;
    String priceCategory; // "budget", "standard", "premium"
    double rating;

    public Product2(String name, String priceCategory, double rating) {
        this.name = name;
        this.priceCategory = priceCategory;
        this.rating = rating;
    }

    // Add getters
    public String getPriceCategory() {
        return priceCategory;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " [" + priceCategory + ", rating: " + rating + "]";
    }
}