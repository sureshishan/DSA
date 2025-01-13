package com.suresh.assignments.lms.managers;

import com.suresh.assignments.lms.entities.Book;

import java.util.List;

public interface BookManager {
    void addBook(Book book);
    void removeBook(String isbn);
    void updateBook(String isbn, String newTitle, String newAuthor, int newYear);
    List<Book> searchBooks(String query);
}
