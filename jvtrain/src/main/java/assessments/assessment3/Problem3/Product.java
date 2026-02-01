package assessments.assessment3.Problem3;

public abstract class Product {
    protected String name;
    protected double price;
    protected String productId;
    protected int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        try {
            setProductId(productId);
            setStockQuantity(stockQuantity);
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
        setName(name);
        setPrice(price);

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setStockQuantity(int stockQuantity) throws OutOfStockException {
        if (stockQuantity == 0) {
            throw new OutOfStockException("Product is out of stock exception....");
        }
        this.stockQuantity = stockQuantity;

    }

    public void setPrice(double price) {
        this.price = price;

    }

    public void setProductId(String productId) throws InvalidProductException {
        if (productId == null || productId.trim().isEmpty()) {
            throw new InvalidProductException("Product ID cannot be null or empty exception...");
        }
        this.productId = productId;
    }

    public abstract double calculateDiscount(double discount);

    public abstract String getProductType();

    public void applyTax(double tax) {
        tax = tax * price;
        price = tax + price;
        System.out.println("The price after tax is KES: " + price);
    }

    public void displayProductInfo() {
        System.out.println("Product: " + name + "\nID: " + productId + "\nPrice KES: " + price);

    }

}
