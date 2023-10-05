# Library Management

### Introduction:

You have been tasked with developing a console-based Library Book Management System for a local library. The library contains a collection of books, each with a title, author name, and a quantity available. Users of the library can borrow and return books one at a time. Your goal is to create a software solution that efficiently manages this library's book inventory through a console interface, without the need for a graphical user interface.

### Problem Statement:

Develop a Library Book Management System console application that allows users to:

- View the list of available books: Users should be able to see a list of all the books in the library, including their titles, authors, and the quantity available.

- Borrow a book: Users should be able to borrow a book from the library. When a book is borrowed, the quantity available should be updated accordingly. A user should not be able to borrow a book if there are no copies available.

- Return a book: Users should be able to return a book to the library. When a book is returned, the quantity available should be updated accordingly. Users should not be able to return more copies of a book than they have borrowed.

- Search for a book: Users should be able to search for a book by title or author name to check its availability in the library.

- Display borrowed books: Users should be able to see a list of books they have currently borrowed.

### Out of Scope:

- Admin and User separation: Ther is no need to add admin authentication or authorisation.

### Requirements:

- The system should be developed as a console-based application.
- Use an in-memory list to store and manage the library's book inventory.
- Implement proper input validation to prevent invalid operations.
- Provide clear and informative text-based output for users.


