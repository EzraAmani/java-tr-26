package Iterator;

public class Book implements Comparable<Book>{
    private String name;
    private String isbn;
    private int year;
    private String authorName;

    public Book(String name, String isbn, int year, String authorName) {
        setName(name);
        setIsbn(isbn);
        setYear(year);
        setAuthorName(authorName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", isbn=" + isbn + ", year=" + year + ", authorName=" + authorName + "]";
    }

        @Override
        public int compareTo(Book o) {
            if (this == o) {
                return 0;
            }
            return Integer.compare(this.year, o.year);
        }
    }


