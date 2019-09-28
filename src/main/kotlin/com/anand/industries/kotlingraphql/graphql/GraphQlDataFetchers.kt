package com.anand.industries.kotlingraphql.graphql

import com.anand.industries.kotlingraphql.dto.Author
import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.rest.BookService
import com.anand.industries.kotlingraphql.rest.person.AuthorRepository
import com.anand.industries.kotlingraphql.rest.person.BookRepository
import com.anand.industries.kotlingraphql.rest.person.HobbieRepository
import graphql.schema.DataFetcher
import org.springframework.stereotype.Component

@Component
class GraphQLDataFetchers(val bookRepository: BookRepository,
                          val authorRepository: AuthorRepository,
                          val hobbieRepository: HobbieRepository,
                          val bookService: BookService
) {

    fun getBookById() = DataFetcher { dataFetchingEnvironment ->
        val bookId = dataFetchingEnvironment.getArgument<String>("id").toInt()

        if(bookId == null)
            bookRepository.findAll()
        else
            bookRepository.findById(bookId)
    }

    fun getAuthorForBook() = DataFetcher { environment ->

        val book = environment.getSource<Book>()
        val ids = book.authors?.map { it.id }

        ids?.let { authorRepository.findAllById(it) }
    }

    fun getHobbiesForAuthor() = DataFetcher { environment ->

        val author = environment.getSource<Author>()
        val ids = author.hobbies?.map { it.id }


        ids?.let { hobbieRepository.findAllById(it) }
    }
}
