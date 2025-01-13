package com.suresh.assignments.lms.entities;

import com.suresh.assignments.lms.policies.lending.LendingPolicy;
import com.suresh.assignments.lms.policies.reservation.ReservationPolicy;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Branch> branches;
    private List<Patron> patrons;
    private LendingPolicy lendingPolicy;
    private ReservationPolicy reservationPolicy;

    public Library(LendingPolicy lendingPolicy, ReservationPolicy reservationPolicy) {
        this.branches = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.lendingPolicy = lendingPolicy;
        this.reservationPolicy = reservationPolicy;
    }

    // Branch Management
    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public Branch findBranch(String branchName) {
        return branches.stream().filter(b -> b.getName().equals(branchName)).findFirst().orElse(null);
    }

    // Patron Management
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public Patron findPatron(String patronId) {
        return patrons.stream().filter(p -> p.getPatronId().equals(patronId)).findFirst().orElse(null);
    }

    public boolean checkoutBook(String isbn, String patronId) {
        Patron patron = findPatron(patronId);
        if (patron == null) return false;
        for (Branch branch : branches) {
            Book book = branch.getBooks().stream().filter(b -> b.getIsbn().equals(isbn) && !b.isBorrowed()).findFirst().orElse(null);
            if (book != null) {
                return lendingPolicy.checkoutBook(book, patron);
            }
        }
        return false;
    }

    public boolean returnBook(String isbn, String patronId) {
        Patron patron = findPatron(patronId);
        if (patron != null) {
            Book book = patron.getBorrowedBooks().stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
            if (book != null) {
                book.setBorrowed(false);
                patron.returnBook(book);
                notifyNextPatron(book);
                return true;
            }
        }
        return false;
    }

    // Reservation Process
    public boolean reserveBook(String isbn, String patronId) {
        Patron patron = findPatron(patronId);
        if (patron == null) return false;

        for (Branch branch : branches) {
            Book book = branch.getBooks().stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
            if (book != null) {
                return reservationPolicy.reserveBook(book, patron);
            }
        }
        return false;
    }


    private void notifyNextPatron(Book book) {
        for (Patron patron : patrons) {
            if (patron.getReservedBooks().contains(book)) {
                patron.getReservedBooks().remove(book);
                System.out.println("Notification: Book " + book.getTitle() + " is now available.");
                break;
            }
        }
    }
}
