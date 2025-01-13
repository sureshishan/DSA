package com.suresh.assignments.lms.driver;

import com.suresh.assignments.lms.entities.Book;
import com.suresh.assignments.lms.entities.Patron;
import com.suresh.assignments.lms.systems.LibraryManagementSystem;
import com.suresh.assignments.lms.systems.RecommendationSystem;

import java.util.List;

public class LibraryManagementDriver {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Add branches
        library.addBranch("Central Library");
        library.addBranch("Westside Branch");

        // Add books
        library.addBook(new Book("Book A", "Author X", "ISBN001", 2020, "Central Library"));
        library.addBook(new Book("Book B", "Author Y", "ISBN002", 2021, "Central Library"));
        library.addBook(new Book("Book C", "Author X", "ISBN003", 2019, "Westside Branch"));

        // Add patrons
        Patron patron1 = new Patron("Alice", "P001");
        Patron patron2 = new Patron("Bob", "P002");

        library.addPatron(patron1);
        library.addPatron(patron2);

        // Subscribe patrons to notifications
        library.getNotificationService().subscribe(patron1);
        library.getNotificationService().subscribe(patron2);

        // Checkout book
        System.out.println("Checking out Book A to Alice...");
        library.checkoutBook("ISBN001", "P001");

        // Return book and trigger notification
        System.out.println("Returning Book A...");
        library.returnBook("ISBN001", "P001");

        // Recommend books
        RecommendationSystem recommendationSystem = new RecommendationSystem(library.getBranches());
        System.out.println("Recommendations for Alice:");
        List<Book> recommendations = recommendationSystem.recommendBooks(patron1);
        recommendations.forEach(System.out::println);
    }
}
