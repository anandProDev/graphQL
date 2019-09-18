package com.anand.industries.kotlingraphql.rest.person

import com.anand.industries.kotlingraphql.dto.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Int>