package assessments.assessment3.Problem1;

public class LibraryTest {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("1", "HarryPotter", "JK Rowling", "1932875", "Novel");
        // "21/02/29");

        // book1.checkout();

        // book1.displayDetails();

        LibraryItem[] items = {
                new Book("B001", "Java Programming", "John Doe", "123-4567890123",
                        "Education"),
                new DVD("D001", "Java Tutorial", "Jane Smith", 120, "PG"),
                new Magazine("M001", "Tech Monthly", "Tech Press", 15, "2024-03-01")
        };

        for (LibraryItem item : items) {
            item.checkout();
            item.displayDetails(); // Each should show different information

            // Each might have different checkout logic
        }
    }

}
