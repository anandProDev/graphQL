package com.anand.industries.kotlingraphql.graphql

import com.anand.industries.kotlingraphql.dto.Author
import com.anand.industries.kotlingraphql.dto.Book
import graphql.schema.DataFetcher
import org.springframework.stereotype.Component
import com.anand.industries.kotlingraphql.graphql.Repository as Database

@Component
class GraphQLDataFetchers(val database: Database) {

    fun getBookById() = DataFetcher { dataFetchingEnvironment ->
        val bookId = dataFetchingEnvironment.getArgument<Int>("id")
        database.getBooks()
            .filter { it.id == bookId }
    }

    fun getAuthorById() = DataFetcher { environment ->

        val authorId = environment.getArgument<String?>("id")

        val authors = database.getAuthors()
        if(authorId == null){
            authors
        }
        else {
            authors.filter { it.id == authorId.toInt() }.firstOrNull()
        }

    }

    fun getBooksByAuthor() = DataFetcher { environment ->

        val author = environment.getSource<Author>()
        database.getBooks()
            .filter { it.id == author.id }
    }

    fun getHobbiesForAuthor() = DataFetcher { environment ->

        val author = environment.getSource<Author>()
        database.getHobbies()
            .filter { author.hobbies.contains(it.id) }
    }

    fun getAuthorForBook() = DataFetcher { environment ->

        val book = environment.getSource<Book>()
        database.getAuthors()
            .filter { it.id == book.id }
    }

    fun getHobbiesById() = DataFetcher { environment ->

        val hobbieId = environment.getArgument<Int>("id")
        database.getHobbies()
            .filter { it.id == hobbieId }
    }
}
