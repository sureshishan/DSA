Seep 1:Understanding the requirements
*************************************

Before jumping into the design, we need to clarify the requirements. Lets assume following for the LMS

Actors:
=======

Librarian:
----------
Responsibilities:
1) Adds/removes/updates books
2) Manage Patrons
3) Transfer books between branches

Patron:
-------
Responsibilities:
1) Searches for books
2) Barrows and returns books
3) Reserve books
4) receive notifications on reserved books

System(Library management System):
----------------------------------
Responsibilities:
1) Manages books, patrons, and branches
2) Handles policies for lending on reservation


Core features:
===============
1) Multi branch support
2) Book management( Add, Update, Delete, Search)
3) Patron management (Add, Update, Search)
4) Borrow and return books.
5) Reserve books and notify patrons when available.
6) Recommendations based on borrowing history.
7) Transfer books between branches.

STEP 2:Analyze Relationships and Behaviours
*******************************************

This step identifies the relationships between entities and their responsibilities

1. Book

   Holds details like title, author, ISBN, publication year, and branch.
   Tracks whether it is borrowed or reserved.

2. Patron

   Represents a user who borrows/reserves books.
   Maintains a record of borrowed and reserved books.

3. Branch

      Represents a library branch.
      Contains a collection of books.

4. Library

   Manages branches, books, and patrons.

5. Policies

   Defines how books are lent and reserved.


STEP 3: Create a class diagram
******************************

Here is the class diagram based on above analysis

Key Relationships:
==================

1. Library has multiple Branches
2. Branch contains multiple Books
3. Patron interacts with Books ( Borrowing and reserving)
4. Library uses Policies for lending and reservations.

Class Diagram:
==============

1. Library

   Attributes: branches, bookManager, patronManager
   Behaviors: addBranch, transferBook, addBook, addPatron, checkoutBook, returnBook, reserveBook.

2. Branch

   Attributes: name, books
   Behaviors: addBook, removeBook.

3. Book

   Attributes: title, author, isbn, publicationYear, isBorrowed, branch.

4. Patron

   Attributes: name, patronId, borrowedBooks, reservedBooks.

5. Policies

   Attributes: LendingPolicy, ReservationPolicy
   Behaviors: checkoutBook, reserveBook.

Step 4: Use Case Diagrams
*************************

Use Case 1: Managing Books

    Actors: Librarian

    Actions:
        Add a book to the library.
        Update book details.
        Remove a book from the library.

Use Case 2: Borrowing a Book

    Actors: Patron

    Actions:
        Search for a book.
        Borrow the book if available.

Use Case 3: Reserving a Book

    Actors: Patron

    Actions:

        Reserve a book.
        Receive notification when the book is available.

Use Case 4: Transferring a Book

    Actors: Librarian

    Actions:
        Transfer a book from one branch to another.

Step 5: Define Relationships in Detail
**************************************

Library → Branch: Aggregation (A library consists of branches).

Branch → Book: Aggregation (A branch contains books).

Patron → Book: Association (Patrons can borrow or reserve books).

Library → Policies: Composition (Policies are integral to the library).

Step 6: Iterative Implementation
********************************

1. Define Interfaces for Abstraction

    LendingPolicy: Interface for lending behavior.
    ReservationPolicy: Interface for reservation behavior.
    BookManager: Interface for book-related operations.
    PatronManager: Interface for patron-related operations.

2. Design Core Classes

    Library: Manages everything.
    Book: Represents a book.
    Patron: Represents a library user.

3. Add Behavior Using Design Patterns

    Strategy Pattern: For flexible lending and reservation policies.
    Observer Pattern: For notifications when reserved books become available.
    Factory Pattern: For creating books, patrons, etc.

Step 7: Create Sequence Diagrams
********************************

    Example: Borrowing a Book

        Patron searches for a book.
        Library checks availability via BookManager.
        If available, Library invokes the lending policy to lend the book to the patron.

Step 8: Finalize the Implementation
***********************************

Once the design is complete, we can implement the system step-by-step, ensuring SOLID principles and design patterns are applied throughout.