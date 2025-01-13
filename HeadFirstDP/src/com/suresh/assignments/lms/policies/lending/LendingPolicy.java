package com.suresh.assignments.lms.policies.lending;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;

public interface LendingPolicy {
    boolean checkoutBook(Book book, Patron patron);
}
