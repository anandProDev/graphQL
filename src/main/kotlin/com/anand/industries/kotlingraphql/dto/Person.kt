package com.anand.industries.kotlingraphql.dto

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(
    @Id
    @GeneratedValue
    val id: Int = 0,
    val name: String,
    val age: Int,
    val emailId: String
//    ,
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    val hobbies: List<Hobbies>
)

//@Entity
//data class Hobbies(
//    @Id
//    @GeneratedValue val id: Int,
//    val personId: Int,
//    @JoinColumn(name = "person_id")
//    val person : Person
//)

//
//@Entity
//class Person {
//
//    @Id
//    @GeneratedValue
//    val id: Int = 0
//    val name: String? = null
//    val age: Int = 0
//    val emailId: String? = null
//}
