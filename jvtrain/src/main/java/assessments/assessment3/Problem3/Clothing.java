package assessments.assessment3.Problem3;

public class Clothing extends Product {
    private int size;
    private String material;
    private String color;

    public Clothing(String name, double price, String productId, int stockQuantity, int size, String material,
            String color) {
        super(productId, name, price, stockQuantity);
        setColor(color);
        setSize(size);
        setMaterial(material);
    }

    public void setSize(int size) {
        this.size = size;

    }

    public void setMaterial(String material) {
        this.material = material;

    }

    public void setColor(String color) {
        this.color = color;

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
                + stockQuantity + "\nSize: " + size + "\nMaterial: " + material + "\nColor: " + color);

    }

}
