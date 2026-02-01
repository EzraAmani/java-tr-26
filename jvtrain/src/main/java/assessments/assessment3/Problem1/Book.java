package assessments.assessment3.Problem1;

public class Book extends LibraryItem {
    private String isbn;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, String genre) {
        super(itemId, title, author);
        setIsbn(isbn);
        setGenre(genre);

    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println(
                "ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nGenre: " + genre
                        + "\nAvailability: " + isAvailable);
    }

}
