package Excercises.javase011.Notifications;

class SMSNotification extends Notification {
    public SMSNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    public void send() {
        System.out.println("Sending SMS...");
        System.out.println("To: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("SMS sent successfully!\n");
    }
}
