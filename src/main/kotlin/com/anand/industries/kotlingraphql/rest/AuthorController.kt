package com.anand.industries.kotlingraphql.rest

import com.anand.industries.kotlingraphql.rest.service.AuthorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import com.anand.industries.kotlingraphql.model.Author as AuthorModel

@RestController
class AuthorController(private val authorService: AuthorService) {

    @GetMapping("/authors/{id}")
    fun getAuthors(@PathVariable("id") id: Int): AuthorModel {

        val author = authorService.getAuthorById(id)
        return author
    }
}

