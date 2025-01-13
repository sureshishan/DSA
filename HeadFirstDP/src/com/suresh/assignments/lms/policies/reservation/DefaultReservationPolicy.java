package com.suresh.assignments.lms.policies.reservation;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;

public class DefaultReservationPolicy implements ReservationPolicy {
    @Override
    public boolean reserveBook(Book book, Patron patron) {
        if (book.isBorrowed()) {
            patron.reserveBook(book);
            return true;
        }
        return false; // Book is not borrowed; no need to reserve.
    }
}
