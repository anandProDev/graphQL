package com.anand.industries.kotlingraphql.rest

import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class PersonService(private val personRepository: PersonRepository) {


    fun getAllPersons(): List<Person> {

        val persons = ArrayList<Person>()
        personRepository.findAll().forEach { persons.add(it) }
        return persons
    }

    fun getPersonById(id: Int): Person {
        return personRepository.findById(id).get()
    }

    fun saveOrUpdate(person: Person) {
        personRepository.save(person)
    }

    fun delete(id: Int) {
        personRepository.deleteById(id)
    }
}