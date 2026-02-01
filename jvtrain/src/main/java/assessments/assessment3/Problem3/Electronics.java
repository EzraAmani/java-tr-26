package assessments.assessment3.Problem3;

public class Electronics extends Product {

    private int warranty;
    private int power;

    public Electronics(String name, double price, String productId, int stockQuantity, int warranty, int power) {
        super(productId, name, price, stockQuantity);
        warrantyPeriod(warranty);
        PowerConsumption(warranty);
    }

    public void warrantyPeriod(int warranty) {
        this.warranty = warranty;

    }

    public void PowerConsumption(int power) {
        this.power = power;

    }

    @Override
    public double calculateDiscount(double discount) {
        discount = discount * price;
        price = price - discount;
        return discount;
    }

    @Override
    public String getProductType() {
        return name;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Product: " + name + "\nID: " + productId + "\nPrice KES: " + price + "\nStock: "
                + stockQuantity + "\nWarranty: " + warranty + " Years\nPower Consumption: " + power + "W");

    }

}
