package com.chitramdasgupta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements Subject {
    private List<Notifier> notifiers;

    public NotificationManager() {
        this.notifiers = new ArrayList<>();
    }

    @Override
    public void registerNotifier(Notifier notifier) {
        notifiers.add(notifier);
    }

    @Override
    public void removeNotifier(Notifier notifier) {
        notifiers.remove(notifier);
    }

    @Override
    public void notifyObservers(String message) {
        notifiers.forEach(notifier -> notifier.sendNotification(message));
    }
}
