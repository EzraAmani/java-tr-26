package Excercises.javase011.Notifications;

public class Main {
    public static void main(String[] args) {
        Notification email = new EmailNotification(
                "user@example.com",
                "Welcome!",
                "Thank you for signing up!");

        Notification sms = new SMSNotification(
                "+1234567890",
                "Your OTP is 123456");

        sms.send();
    }
}
