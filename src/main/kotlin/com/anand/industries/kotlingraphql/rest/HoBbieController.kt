package com.anand.industries.kotlingraphql.rest

import com.anand.industries.kotlingraphql.rest.person.HobbieRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HobbieController(private val hobbieRepository: HobbieRepository) {

    @GetMapping("/hobbies/{id}")
    private fun getAuthors(@PathVariable("id") id: Int) = hobbieRepository.findById(id).get()

}