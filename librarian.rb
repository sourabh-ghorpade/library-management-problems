class Book
  attr_accessor :title, :author, :quantity, :borrowed

  def initialize(title, author, quantity)
    @title = title
    @author = author
    @quantity = quantity
    @borrowed = 0
  end
end

class Library
  def initialize
    @books = []
  end

  def add_book(title, author, quantity)
    book = Book.new(title, author, quantity)
    @books << book
    puts "Book added to the library."
  end

  def display_books
    if @books.empty?
      puts "The library is empty."
    else
      puts "Library Catalog:"
      @books.each do |book|
        puts "Title: #{book.title}, Author: #{book.author}, Available: #{book.quantity - book.borrowed}"
      end
    end
  end

  def return_book(title)
    @books.each do |book|
      if book.title.downcase == title.downcase
        if book.borrowed >= 0
          book.borrowed -= 1
          puts "Book returned successfully."
        else
          puts "You haven't borrowed this book."
        end
        return
      end
    end
    puts "Book not found in the library."
  end
end

library = Library.new

loop do
  puts "\nLibrary Management System"
  puts "1. Add Book"
  puts "2. Display Available Books"
  puts "3. Borrow Book"
  puts "4. Return Book"
  puts "5. Quit"

  choice = gets.chomp

  case choice
  when "1"
    print "Enter book title: "
    title = gets.chomp
    print "Enter author name: "
    author = gets.chomp
    print "Enter quantity available: "
    quantity = gets.chomp.to_i
    library.add_book(title, author, quantity)
  when "2"
    library.display_books
  when "4"
    print "Enter the title of the book you want to return: "
    title = gets.chomp
    library.return_book(title)
  when "5"
    puts "Exiting the library system."
    break
  else
    puts "Invalid choice. Please try again."
  end
end
