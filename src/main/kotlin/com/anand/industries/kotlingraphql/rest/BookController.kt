package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.rest.service.BookService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val bookService: BookService) {

    @GetMapping("/books")
    fun getAllBooks() = bookService.getAllBooks()

    @GetMapping("/books/{id}")
    fun getBook(@PathVariable("id") id: Int) = bookService.getBookById(id)


    @DeleteMapping("/books/{id}")
    fun deleteBook(@PathVariable("id") id: Int) {
        bookService.delete(id)
    }

    @PostMapping("/books")
    fun saveBook(@RequestBody book: Book) =
        bookService.saveOrUpdate(book)
}

