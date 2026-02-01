package assessments.assessment3.Problem1;

public class DVD extends LibraryItem {
    private int duration;
    private String rating;

    public DVD(String itemId, String title, String author, int duration, String rating) {
        super(itemId, title, author);
        setDuration(duration);
        setRating(rating);

    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public void displayDetails() {
        System.out.println(
                "ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author + "\nDuration: " + duration + "\nrating: "
                        + rating
                        + "\nAvailability: " + isAvailable);
    }

}
