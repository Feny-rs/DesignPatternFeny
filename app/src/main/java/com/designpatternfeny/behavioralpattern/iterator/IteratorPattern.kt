package com.designpatternfeny.behavioralpattern.iterator

// Iterator interface
interface Iterator {
    fun hasNext(): Boolean
    fun next(): Book
}

// Aggregate interface
interface BookCollection {
    fun iterator(): Iterator
}

// Concrete Iterator
class BookIterator(private val books: List<Book>) : Iterator {
    private var currentPosition = 0

    override fun hasNext(): Boolean {
        return currentPosition < books.size
    }

    override fun next(): Book {
        val book = books[currentPosition]
        currentPosition++
        return book
    }
}

// Concrete Aggregate
class Library : BookCollection {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    override fun iterator(): Iterator {
        return BookIterator(books)
    }
}

// Concrete Element
data class Book(val title: String, val author: String)

// Client (Usage)
fun main() {
    val library = Library()
    library.addBook(Book("The Catcher in the Rye", "J.D. Salinger"))
    library.addBook(Book("To Kill a Mockingbird", "Harper Lee"))
    library.addBook(Book("1984", "George Orwell"))

    val iterator = library.iterator()

    while (iterator.hasNext()) {
        val book = iterator.next()
        println("Book: ${book.title} by ${book.author}")
    }
}