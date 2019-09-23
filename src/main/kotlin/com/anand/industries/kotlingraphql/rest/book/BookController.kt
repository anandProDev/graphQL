package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Book
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val bookService: BookService) {

    @GetMapping("/books")
    private fun getAllBooks() = bookService.getAllBooks()

    @GetMapping("/books/{id}")
    private fun getBook(@PathVariable("id") id: Int): Book {
        return bookService.getBookById(id)
    }

    @DeleteMapping("/books/{id}")
    private fun deleteBook(@PathVariable("id") id: Int) {
        bookService.delete(id)
    }

    @PostMapping("/books")
    private fun saveBook(@RequestBody person: Book): Int {
        bookService.saveOrUpdate(person)
        return person.id
    }
}