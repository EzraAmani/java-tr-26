package Excercises.javase017.comparable2;

class Book2 {
    String title;
    int year;

    public Book2(String title, int year) {
        this.title = title;
        this.year = year;
    }

    // Add getters
    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}