package assessments.assessment3.Problem3;

public class ECommerceTest {
    public static void main(String[] args) {

        Electronics laptop = new Electronics("Acer", 99.99, "6", 90, 4, 20);
        Product book1 = new Books("HarryPotter", 99.99, "BMC45", 0, "BM88", "Fiction", "JK Rowling");

        book1.displayProductInfo();

    }

}
