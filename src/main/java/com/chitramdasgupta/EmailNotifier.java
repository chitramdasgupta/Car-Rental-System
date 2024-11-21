package com.chitramdasgupta;

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending message: " + message);
    }
}
