package com.suresh.assignments.lms.entities;

import com.suresh.assignments.lms.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Book> books;

    public Branch(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    // Actions
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
