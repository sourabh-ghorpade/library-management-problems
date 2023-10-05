package main

import (
	"fmt"
	"strings"
)

type Book struct {
	Title     string
	Author    string
	Quantity  int
	Borrowed  int
}

type Library struct {
	Books []*Book
}

func NewLibrary() *Library {
	return &Library{}
}

func (l *Library) AddBook(title, author string, quantity int) {
	book := &Book{Title: title, Author: author, Quantity: quantity}
	l.Books = append(l.Books, book)
	fmt.Println("Book added to the library.")
}

func (l *Library) DisplayBooks() {
	if len(l.Books) == 0 {
		fmt.Println("The library is empty.")
	} else {
		fmt.Println("Library Catalog:")
		for _, book := range l.Books {
			fmt.Printf("Title: %s, Author: %s, Available: %d\n", book.Title, book.Author, book.Quantity-book.Borrowed)
		}
	}
}

func (l *Library) ReturnBook(title string) {
	for _, book := range l.Books {
		if strings.EqualFold(book.Title, title) {
			if book.Borrowed >= 0 {
				book.Borrowed--
				fmt.Println("Book returned successfully.")
			} else {
				fmt.Println("You haven't borrowed this book.")
			}
			return
		}
	}
	fmt.Println("Book not found in the library.")
}

func main() {
	library := NewLibrary()

	for {
		fmt.Println("\nLibrary Management System")
		fmt.Println("1. Add Book")
		fmt.Println("2. Display Available Books")
		fmt.Println("3. Borrow Book")
		fmt.Println("4. Return Book")
		fmt.Println("5. Quit")

		var choice string
		fmt.Print("Enter your choice: ")
		fmt.Scanln(&choice)

		switch choice {
		case "1":
			var title, author string
			var quantity int
			fmt.Print("Enter book title: ")
			fmt.Scanln(&title)
			fmt.Print("Enter author name: ")
			fmt.Scanln(&author)
			fmt.Print("Enter quantity available: ")
			fmt.Scanln(&quantity)
			library.AddBook(title, author, quantity)

		case "2":
			library.DisplayBooks()

		case "4":
			var title string
			fmt.Print("Enter the title of the book you want to return: ")
			fmt.Scanln(&title)
			library.ReturnBook(title)

		case "5":
			fmt.Println("Exiting the library system.")
		
