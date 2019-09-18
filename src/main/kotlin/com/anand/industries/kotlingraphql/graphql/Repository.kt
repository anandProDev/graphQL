package com.anand.industries.kotlingraphql.graphql

import com.anand.industries.kotlingraphql.dto.Author
import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.dto.Hobbie
import org.springframework.stereotype.Repository

@Repository
class Repository {


    fun getBooks(): List<Book> {

        return listOf(
            Book(
                id = 1,
                name = "DaVinci code",
                pageCount = 500,
                authorId = 1
            ),
            Book(
                id = 2,
                name = "Lost symbols",
                pageCount = 300,
                authorId = 1
            ),
            Book(
                id = 3,
                name = "Tell me your dreams",
                pageCount = 200,
                authorId = 2
            ),
            Book(
                id = 4,
                name = "Harry Potter and the Philosopher's Stone",
                pageCount = 200,
                authorId = 3
            )
        )
    }

    fun getAuthors(): List<Author> {
        return listOf(
            Author(
                id = 1,
                firstName = "Dan",
                lastName = "Brown",
                hobbies = listOf(1, 2)
            ),
            Author(
                id = 2,
                firstName = "Sidney",
                lastName = "Sheldon",
                hobbies = listOf(1)
            ),
            Author(
                id = 3,
                firstName = "Joanne",
                lastName = "Rowling",
                hobbies = listOf(2)
            )
        )
    }

    fun getHobbies(): List<Hobbie> {

        return listOf(
            Hobbie(
                id = 1,
                name = "Singing"
            ),
            Hobbie(
                id = 2,
                name = "Dancing"
            )
        )
    }
}



