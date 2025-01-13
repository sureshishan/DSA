package com.suresh.assignments.lms.policies.lending;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;

public class DefaultLendingPolicy implements LendingPolicy {
    @Override
    public boolean checkoutBook(Book book, Patron patron) {
        if (book.isBorrowed()) {
            return false; // Book is already borrowed.
        }
        book.setBorrowed(true);
        patron.borrowBook(book);
        return true;
    }
}
