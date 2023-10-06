package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int quantity;
    private int borrowed;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.borrowed = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBorrowed() {
        return borrowed;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author, int quantity) {
        Book book = new Book(title, author, quantity);
        books.add(book);
        System.out.println("java.Book added to the library.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("java.Library Catalog:");
            for (Book book : books) {
                System.out.printf("Title: %s, Author: %s, Available: %d%n",
                        book.getTitle(), book.getAuthor(), book.getQuantity() - book.getBorrowed());
            }
        }
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getBorrowed() >= 0) {
                    System.out.println("java.Book returned successfully.");
                } else {
                    System.out.println("You haven't borrowed this book.");
                }
                return;
            }
        }
        System.out.println("java.Book not found in the library.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\njava.Library Management System");
            System.out.println("1. Add java.Book");
            System.out.println("2. Display Available Books");
            System.out.println("3. Borrow java.Book");
            System.out.println("4. Return java.Book");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity available: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    library.addBook(title, author, quantity);
                    break;
                case "2":
                    library.displayBooks();
                    break;
                case "3":
                    System.out.print("Enter the title of the book you want to borrow: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case "4":
                    System.out.print("Enter the title of the book you want to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case "5":
                    System.out.println("Exiting the library system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
