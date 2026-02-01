package assessments.assessment3.Problem1;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private String publicationDate;

    public Magazine(String itemId, String title, String author, int issueNumber, String publicationDate) {
        super(itemId, title, author);
        setIssueNumber(issueNumber);
        setPublicationDate(publicationDate);

    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public void displayDetails() {
        System.out.println(
                "ID: " + itemId + "\nTitle: " + title + "\nAuthor: " + author + "\nIssue Number: " + issueNumber
                        + "\nPublication Date: "
                        + publicationDate
                        + "\nAvailability: " + isAvailable);
    }

}
