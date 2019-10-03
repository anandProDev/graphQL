package com.anand.industries.kotlingraphql.rest.mapper

import com.anand.industries.kotlingraphql.dto.Author
import com.anand.industries.kotlingraphql.model.Author as AuthorModel

object AuthorMapper {

    fun map(author: Author) =
        with(author) {
            AuthorModel(
                id = id,
                firstName = firstName,
                lastName = lastName,
                hobbieHref = hobbies.map { "http://localhost:8080/hobbies/${it.id}" }
            )
        }
}
