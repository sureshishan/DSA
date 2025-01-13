package com.suresh.assignments.lms.policies.reservation;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;

public interface ReservationPolicy {
    boolean reserveBook(Book book, Patron patron);
}
