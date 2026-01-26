package Excercises.javase011.Notifications;

abstract class Notification {
    protected String recipient;
    protected String message;

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public abstract void send();
}
