package com.anand.industries.kotlingraphql.rest

import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Int>