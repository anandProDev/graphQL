package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Book
import com.anand.industries.kotlingraphql.dto.Person
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Int>