package com.suresh.assignments.lms.notification;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {
    private List<Observer> observers;

    public NotificationService() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void notifyBookAvailability(Book book) {
        String message = "The book '" + book.getTitle() + "' is now available.";
        notifyObservers(message);
    }
}
