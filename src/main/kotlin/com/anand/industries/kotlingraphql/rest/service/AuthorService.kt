package com.anand.industries.kotlingraphql.rest.service

import com.anand.industries.kotlingraphql.rest.mapper.AuthorMapper
import com.anand.industries.kotlingraphql.rest.person.AuthorRepository
import org.springframework.stereotype.Component
import com.anand.industries.kotlingraphql.model.Author as AuthorModel

@Component
class AuthorService(private val authorRepository: AuthorRepository) {

    fun getAuthorById(id: Int): AuthorModel {
        val author = authorRepository.findById(id).get()
        return AuthorMapper.map(author)
    }
}
