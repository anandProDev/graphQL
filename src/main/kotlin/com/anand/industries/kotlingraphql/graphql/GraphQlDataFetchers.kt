package com.anand.industries.kotlingraphql.graphql

import com.anand.industries.kotlingraphql.rest.service.BookService
import com.anand.industries.kotlingraphql.model.Book as BookModel
import com.anand.industries.kotlingraphql.model.Author as AuthorModel
import com.anand.industries.kotlingraphql.rest.service.AuthorService
import com.anand.industries.kotlingraphql.rest.service.HobbieService
import graphql.schema.DataFetcher
import org.springframework.stereotype.Component

@Component
class GraphQLDataFetchers(val bookService: BookService,
                          val authorService: AuthorService,
                          val hobbieService: HobbieService
) {

    fun getBooks() = DataFetcher { dataFetchingEnvironment ->
        val bookId = dataFetchingEnvironment.getArgument<String>("id")

        val name = dataFetchingEnvironment.getArgument<String>("name")

        when {
            bookId == null && name != null -> bookService.getAllBooks().filter {it.name == name}
            bookId != null && name == null -> bookService.getBookById(bookId.toInt())
            bookId != null && name != null -> {
                val book = bookService.getBookById(bookId.toInt())
                val book1 = if (book.first().name == name)
                    book
                else
                    null
                book1
            }
            else -> bookService.getAllBooks()
        }
    }

    fun getAuthorForBook() = DataFetcher { environment ->

        val book = environment.getSource<BookModel>()
        val authorName  = environment.getArgument<String?>("firstName")
        val ids = book.authorIds
        val authors = ids.map { authorService.getAuthorById(it) }

        authorName?.let { authors.filter { it.firstName.equals(authorName) } }
            ?: authors
    }

    fun getHobbiesForAuthor() = DataFetcher { environment ->

        val hobbieName  = environment.getArgument<String?>("hobbieName")

        val authors = environment.getSource<AuthorModel>()
        val ids = authors.hobbieIds

        val hobbies = ids.let { hobbieService.getHobbiesByIds(it) }

        hobbieName?.let { hobbies.filter { it.name.equals(hobbieName) } } ?: hobbies

    }
}
