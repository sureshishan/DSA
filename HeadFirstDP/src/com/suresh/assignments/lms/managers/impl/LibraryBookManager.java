package com.suresh.assignments.lms.managers.impl;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.managers.BookManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibraryBookManager implements BookManager {
    private Map<String, List<Book>> branches;

    public LibraryBookManager(Map<String, List<Book>> branches) {
        this.branches = branches;
    }

    @Override
    public void addBook(Book book) {
        branches.computeIfAbsent(book.getBranch(), k -> new ArrayList<>()).add(book);
    }

    @Override
    public void removeBook(String isbn) {
        for (List<Book> books : branches.values()) {
            books.removeIf(book -> book.getIsbn().equals(isbn));
        }
    }

    @Override
    public void updateBook(String isbn, String newTitle, String newAuthor, int newYear) {
        for (List<Book> books : branches.values()) {
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                if (book.getIsbn().equals(isbn)) {
                    books.set(i, new Book(newTitle, newAuthor, isbn, newYear, book.getBranch()));
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
    }

    @Override
    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (List<Book> books : branches.values()) {
            for (Book book : books) {
                if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getIsbn().equals(query)) {
                    results.add(book);
                }
            }
        }
        return results;
    }
}
