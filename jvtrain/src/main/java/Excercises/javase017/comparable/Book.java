package Excercises.javase017.comparable;

class Book implements Comparable<Book> {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public int compareTo(Book other) {
        // First compare by title
        int titleCompare = this.title.compareTo(other.title);
        if (titleCompare != 0)
            return titleCompare;

        // If titles are equal, compare by author
        return this.author.compareTo(other.author);
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}