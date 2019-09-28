package com.anand.industries.kotlingraphql.mapper

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
                pageCount = pageCount,
                authorIds = book.authors.map { it.id }
            )
        }
}
