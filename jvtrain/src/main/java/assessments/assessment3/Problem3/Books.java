package assessments.assessment3.Problem3;

public class Books extends Product {
    private String isbn;
    private String genre;
    private String publisher;

    public Books(String name, double price, String productId, int stockQuantity, String isbn, String genre,
            String publisher) {
        super(productId, name, price, stockQuantity);
        setIsbn(isbn);
        setGenre(genre);
        setPublisher(publisher);

    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
                + stockQuantity + "\nISBN: " + isbn + "\nGenre: " + genre + "\npublisher: " + publisher);

    }

}
