package Excercises.javase011.Notifications;

class EmailNotification extends Notification {
    private String subject;

    public EmailNotification(String recipient, String subject, String message) {
        super(recipient, message);
        this.subject = subject;
    }

    @Override
    public void send() {
        System.out.println("Sending Email...");
        System.out.println("To: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("Email sent successfully!\n");
    }
}