package com.suresh.assignments.lms.systems;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationSystem {
    private Map<String, List<Book>> branches;

    public RecommendationSystem(Map<String, List<Book>> branches) {
        this.branches = branches;
    }

    public List<Book> recommendBooks(Patron patron) {
        Set<String> authors = patron.getBorrowedBooks().stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());

        return branches.values().stream()
                .flatMap(Collection::stream)
                .filter(book -> !book.isBorrowed() && authors.contains(book.getAuthor()))
                .collect(Collectors.toList());
    }
}
