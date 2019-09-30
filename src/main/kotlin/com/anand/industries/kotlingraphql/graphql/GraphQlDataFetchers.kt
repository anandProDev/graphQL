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

    fun getBookById() = DataFetcher { dataFetchingEnvironment ->
        val bookId = dataFetchingEnvironment.getArgument<String>("id").toIntOrNull()

        val name = dataFetchingEnvironment.getArgument<String>("name")

        when {
            bookId == null && name != null -> bookService.getAllBooks().filter {it.name == name}
            bookId != null && name == null -> bookService.getBookById(bookId)
            bookId != null && name != null -> {
                val book = bookService.getBookById(bookId)
                val book1 = if (book.name == name)
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
        val ids = book.authorIds
        ids.map { authorService.getAuthorById(it) }
    }

    fun getHobbiesForAuthor() = DataFetcher { environment ->

        val argument = environment.getArgument<String>("filter")
        val authors = environment.getSource<AuthorModel>()
        val ids = authors.hobbieIds

        ids.let { hobbieService.getHobbiesByIds(it) }
    }
}
