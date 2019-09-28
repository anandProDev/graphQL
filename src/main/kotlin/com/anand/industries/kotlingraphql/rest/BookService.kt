package com.anand.industries.kotlingraphql.rest

import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.model.Book as BookModel
import com.anand.industries.kotlingraphql.rest.person.BookRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class BookService(private val bookRepository: BookRepository,
                  private val bookMapper: (Book) -> BookModel) {

    fun getAllBooks() : List<BookModel> {
        val books = bookRepository.findAll()
        return books.map(bookMapper)
    }

    fun getBookById(id: Int): BookModel {
        val book = bookRepository.findById(id).get()
        return bookMapper(book)
    }

    fun saveOrUpdate(book: Book) = bookRepository.save(book)

    fun delete(id: Int) = bookRepository.deleteById(id)
}
