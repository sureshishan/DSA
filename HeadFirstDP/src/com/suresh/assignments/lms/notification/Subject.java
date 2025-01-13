package com.suresh.assignments.lms.notification;

import com.suresh.assignments.lms.observer.Observer;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String message);
}
