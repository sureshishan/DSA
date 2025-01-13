package com.suresh.assignments.lms.systems;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;
import com.suresh.assignments.lms.managers.BookManager;
import com.suresh.assignments.lms.managers.PatronManager;
import com.suresh.assignments.lms.managers.impl.LibraryBookManager;
import com.suresh.assignments.lms.notification.NotificationService;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryManagementSystem {

    private Map<String, List<Book>> branches; // Maps branch names to their book collections
    private BookManager bookManager; // Handles book management
    private PatronManager patronManager; // Handles patron management
    private NotificationService notificationService; // Handles notifications

    public LibraryManagementSystem() {
        this.branches = new HashMap<>();
        this.bookManager = new LibraryBookManager(branches);
        this.patronManager = new PatronManager();
        this.notificationService = new NotificationService();
    }

    // Branch Management
    public void addBranch(String branchName) {
        branches.putIfAbsent(branchName, new ArrayList<>());
    }

    public void transferBook(String isbn, String fromBranch, String toBranch) {
        List<Book> fromBooks = branches.get(fromBranch);
        List<Book> toBooks = branches.get(toBranch);
        if (fromBooks != null && toBooks != null) {
            for (Iterator<Book> it = fromBooks.iterator(); it.hasNext(); ) {
                Book book = it.next();
                if (book.getIsbn().equals(isbn)) {
                    it.remove();
                    book.setBranch(toBranch);
                    toBooks.add(book);
                    break;
                }
            }
        }
    }

    // Book Management
    public void addBook(Book book) {
        bookManager.addBook(book);
    }

    public void removeBook(String isbn) {
        bookManager.removeBook(isbn);
    }

    public void updateBook(String isbn, String newTitle, String newAuthor, int newYear) {
        bookManager.updateBook(isbn, newTitle, newAuthor, newYear);
    }

    public List<Book> searchBooks(String query) {
        return bookManager.searchBooks(query);
    }

    // Patron Management
    public void addPatron(Patron patron) {
        patronManager.addPatron(patron);
        notificationService.subscribe(patron); // Subscribing patrons to notifications
    }

    public void updatePatron(String patronId, String newName) {
        patronManager.updatePatron(patronId, newName);
    }

    public Patron findPatron(String patronId) {
        return patronManager.findPatron(patronId);
    }

    // Lending Process
    public boolean checkoutBook(String isbn, String patronId) {
        Patron patron = patronManager.findPatron(patronId);
        if (patron == null) return false;

        for (List<Book> books : branches.values()) {
            Book book = books.stream().filter(b -> b.getIsbn().equals(isbn) && !b.isBorrowed()).findFirst().orElse(null);
            if (book != null) {
                book.setBorrowed(true);
                patron.borrowBook(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String isbn, String patronId) {
        Patron patron = patronManager.findPatron(patronId);
        if (patron != null) {
            for (Iterator<Book> it = patron.getBorrowedBooks().iterator(); it.hasNext(); ) {
                Book book = it.next();
                if (book.getIsbn().equals(isbn)) {
                    book.setBorrowed(false);
                    it.remove();

                    // Notify patrons about availability
                    notificationService.notifyBookAvailability(book);

                    return true;
                }
            }
        }
        return false;
    }

    // Reservation System
    public boolean reserveBook(String isbn, String patronId) {
        Patron patron = patronManager.findPatron(patronId);
        if (patron != null) {
            for (List<Book> books : branches.values()) {
                Book book = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
                if (book != null && book.isBorrowed()) {
                    patron.reserveBook(book);
                    return true;
                }
            }
        }
        return false;
    }

    // Inventory Management
    public List<Book> getAvailableBooks(String branch) {
        return branches.getOrDefault(branch, Collections.emptyList()).stream()
                .filter(book -> !book.isBorrowed())
                .collect(Collectors.toList());
    }

    public List<Book> getBorrowedBooks(String branch) {
        return branches.getOrDefault(branch, Collections.emptyList()).stream()
                .filter(Book::isBorrowed)
                .collect(Collectors.toList());
    }

    // Recommendation System
    public List<Book> recommendBooks(String patronId) {
        Patron patron = patronManager.findPatron(patronId);
        if (patron == null) return Collections.emptyList();

        Set<String> authors = patron.getBorrowedBooks().stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());

        return branches.values().stream()
                .flatMap(Collection::stream)
                .filter(book -> !book.isBorrowed() && authors.contains(book.getAuthor()))
                .collect(Collectors.toList());
    }

    // Getter for NotificationService (for testing)
    public NotificationService getNotificationService() {
        return notificationService;
    }

    // Getter for branches (for testing)
    public Map<String, List<Book>> getBranches() {
        return branches;
    }
}
