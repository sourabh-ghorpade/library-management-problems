data class Book(var title: String, var author: String, var quantity: Int, var borrowed: Int = 0)

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(title: String, author: String, quantity: Int) {
        val book = Book(title, author, quantity)
        books.add(book)
        println("Book added to the library.")
    }

    fun displayBooks() {
        if (books.isEmpty()) {
            println("The library is empty.")
        } else {
            println("Library Catalog:")
            books.forEach { book ->
                println("Title: ${book.title}, Author: ${book.author}, Available: ${book.quantity - book.borrowed}")
            }
        }
    }

    fun returnBook(title: String) {
        books.forEach { book ->
            if (book.title.equals(title, ignoreCase = true)) {
                if (book.borrowed >= 0) {
                    book.borrowed--
                    println("Book returned successfully.")
                } else {
                    println("You haven't borrowed this book.")
                }
                return
            }
        }
        println("Book not found in the library.")
    }
}

fun main() {
    val library = Library()

    while (true) {
        println("\nLibrary Management System")
        println("1. Add Book")
        println("2. Display Available Books")
        println("4. Return Book")
        println("5. Quit")
        print("Enter your choice: ")
        val choice = readLine()

        when (choice) {
            "1" -> {
                print("Enter book title: ")
                val title = readLine() ?: ""
                print("Enter author name: ")
                val author = readLine() ?: ""
                print("Enter quantity available: ")
                val quantity = readLine()?.toIntOrNull() ?: 0
                library.addBook(title, author, quantity)
            }
            "2" -> library.displayBooks()
            "4" -> {
                print("Enter the title of the book you want to return: ")
                val title = readLine() ?: ""
                library.returnBook(title)
            }
            "5" -> {
                println("Exiting the library system.")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}
