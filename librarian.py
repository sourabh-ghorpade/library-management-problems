class Book:
    def __init__(self, title, author, quantity):
        self.title = title
        self.author = author
        self.quantity = quantity
        self.borrowed = 0

class Library:
    def __init__(self):
        self.books = []

    def add_book(self, title, author, quantity):
        book = Book(title, author, quantity)
        self.books.append(book)
        print("Book added to the library.")

    def display_books(self):
        if not self.books:
            print("The library is empty.")
        else:
            print("Library Catalog:")
            for book in self.books:
                print(f"Title: {book.title}, Author: {book.author}, Available: {book.quantity - book.borrowed}")
    
    def borrow_book(self, title):
        for book in self.books:
            if book.title.lower() == title.lower():
                if book.borrowed < book.quantity:
                    book.borrowed += 1
                    print("Book borrowed successfully.")
                else:
                    print("Sorry, this book is not available for borrowing.")
                return
        print("Book not found in the library.")

    def return_book(self, title):
        for book in self.books:
            if book.title.lower() == title.lower():
                if book.borrowed >= 0:
                    book.borrowed -= 1
                    print("Book returned successfully.")
                else:
                    print("You haven't borrowed this book.")
                return
        print("Book not found in the library.")

if __name__ == "__main__":
    library = Library()

    while True:
        print("\nLibrary Management System")
        print("1. Add Book")
        print("2. Display Available Books")
        print("3. Borrow Book")
        print("4. Return Book")
        print("5. Quit")

        choice = input("Enter your choice: ")

        if choice == "1":
            title = input("Enter book title: ")
            author = input("Enter author name: ")
            quantity = int(input("Enter quantity available: "))
            library.add_book(title, author, quantity)

        elif choice == "2":
            library.display_books()

        elif choice == "4":
            title = input("Enter the title of the book you want to return: ")
            library.return_book(title)

        elif choice == "5":
            print("Exiting the library system.")
            break

        else:
            print("Invalid choice. Please try again.")
