package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.dto.Person
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> {

        val books = ArrayList<Book>()
        bookRepository.findAll().forEach { books.add(it) }
        return books
    }

    fun getBookById(id: Int): Book {
        return bookRepository.findById(id).get()
    }

    fun saveOrUpdate(book: Book) {
        bookRepository.save(book)
    }

    fun delete(id: Int) {
        bookRepository.deleteById(id)
    }
}