package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Int>