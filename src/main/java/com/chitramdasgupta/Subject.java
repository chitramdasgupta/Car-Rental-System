package com.chitramdasgupta;

public interface Subject {
    void registerNotifier(Notifier notifier);

    void removeNotifier(Notifier notifier);

    void notifyObservers(String message);
}
