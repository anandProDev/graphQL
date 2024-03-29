package com.anand.industries.kotlingraphql.rest.mapper

import com.anand.industries.kotlingraphql.dto.Book
import org.springframework.stereotype.Component
import com.anand.industries.kotlingraphql.model.Book as BookModel

@Component
class BookMapper : (Book) -> BookModel {
    override fun invoke(book: Book) =

        with(book) {
            BookModel(
                id = id,
                name = name,
                //pageCount = pageCount,
                authorHref = book.authors.map { "http://localhost:8080/authors/${it.id}" }
            )
        }
}
