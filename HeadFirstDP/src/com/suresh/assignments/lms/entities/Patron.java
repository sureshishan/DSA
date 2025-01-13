package com.suresh.assignments.lms.entities;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.observer.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Patron implements Observer {
    private String name;
    private String patronId;
    private List<Book> borrowedBooks;
    private Queue<Book> reservedBooks;

    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new LinkedList<>();
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getPatronId() { return patronId; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public Queue<Book> getReservedBooks() { return reservedBooks; }

    // Actions
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", patronId='" + patronId + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", reservedBooks=" + reservedBooks +
                '}';
    }

    // Observer method
    @Override
    public void update(String message) {
        System.out.println("Notification for Patron " + name + ": " + message);
    }
}
