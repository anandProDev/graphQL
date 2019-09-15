package com.anand.industries.kotlingraphql.rest

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person {

    @Id
    @GeneratedValue
    val id: Int = 0
    val name: String? = null
    val age: Int = 0
    val emailId: String? = null
}
