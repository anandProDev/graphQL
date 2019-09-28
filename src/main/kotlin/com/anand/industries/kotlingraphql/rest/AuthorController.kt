package com.anand.industries.kotlingraphql.rest

import com.anand.industries.kotlingraphql.dto.Author
import com.anand.industries.kotlingraphql.model.Author as AuthorModel
import com.anand.industries.kotlingraphql.rest.person.AuthorRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(private val authorRepository: AuthorRepository) {

    @GetMapping("/authors/{id}")
    private fun getAuthors(@PathVariable("id") id: Int): AuthorModel {

        val author = authorRepository.findById(id).get()
        return AuthorMapper.map(author)
    }
}


object AuthorMapper {

    fun map(author: Author) =
        with(author) {
            AuthorModel(
                id = id,
                firstName = firstName,
                lastName = lastName,
                hobbieIds = hobbies.map { it.id }
            )
        }
    }
