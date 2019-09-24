package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Author
import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.dto.Hobbie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository : JpaRepository<Book, Int> {


    fun findBooksByAuthors(authors: List<Author>) : List<Book>

}

interface AuthorRepository : JpaRepository<Author, Int> {

}


interface HobbieRepository : JpaRepository<Hobbie, Int> {

}




