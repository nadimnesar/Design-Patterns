package main;

public class FactoryPattern {
    public static void main(String[] args) {
        // Here, an email type notification object is created without exposing the creation logic.
        Notification notification = NotificationFactory.createNotification("EMAIL");
        if (notification != null) {
            notification.notifyUser("ABC");
        }
    }
}

/**
 * The NotificationFactory class creates objects without exposing the creation logic.
 * This is useful when object creation is very complex.
 */
class NotificationFactory {
    public static Notification createNotification(String notificationType) {
        return switch (notificationType) {
            case "EMAIL" -> new EmailNotification();
            case "PUSH" -> new PushNotification();
            case "SMS" -> new SMSNotification();
            default -> null;
        };
    }
}

interface Notification {
    void notifyUser(String message);
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Email sent: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Push notification sent: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("SMS sent: " + message);
    }
}
