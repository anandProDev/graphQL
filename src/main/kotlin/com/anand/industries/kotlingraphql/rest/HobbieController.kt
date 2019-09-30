package com.anand.industries.kotlingraphql.rest

import com.anand.industries.kotlingraphql.rest.service.HobbieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HobbieController(private val hobbieService: HobbieService) {

    @GetMapping("/hobbies/{id}")
    private fun getHobbies(@PathVariable("id") id: Int) = hobbieService.getHobbieById(id)
}

