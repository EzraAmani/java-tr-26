package assessments.assessment3.Problem1;

public class LibraryItem {
    // these are the objects
    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isAvailable;

    // I will initialize the constructor using setters
    public LibraryItem(String itemId, String title, String author) {
        setItemId(itemId);
        setTitle(title);
        setAuthor(author);
        this.isAvailable = true;

    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed the book " + title);
        } else {
            System.out.println("The book " + title + " is not available");
        }
    }

    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have returned the book " + title);
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    public void displayDetails() {
        System.out.println(
                "ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author + "\nAvailability: " + isAvailable);
    }

}
