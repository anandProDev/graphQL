package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Person
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val personService: PersonService) {

    @GetMapping("/persons")
    private fun getAllPersons() = personService.getAllPersons()

    @GetMapping("/persons/{id}")
    private fun getPerson(@PathVariable("id") id: Int): Person {
        return personService.getPersonById(id)
    }

    @DeleteMapping("/persons/{id}")
    private fun deletePerson(@PathVariable("id") id: Int) {
        personService.delete(id)
    }

    @PostMapping("/persons")
    private fun savePerson(@RequestBody person: Person): Int {
        personService.saveOrUpdate(person)
        return person.id
    }
}