package com.anand.industries.kotlingraphql.rest.mapper

import com.anand.industries.kotlingraphql.dto.Author

object AuthorMapper {

    fun map(author: Author) =
        with(author) {
            com.anand.industries.kotlingraphql.model.Author(
                id = id,
                firstName = firstName,
                lastName = lastName,
                hobbieIds = hobbies.map { it.id }
            )
        }
}
