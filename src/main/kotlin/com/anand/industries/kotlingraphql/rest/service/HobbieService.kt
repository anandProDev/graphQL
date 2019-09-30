package com.anand.industries.kotlingraphql.rest.service

import com.anand.industries.kotlingraphql.model.Hobbie as HobbieModel
import com.anand.industries.kotlingraphql.rest.mapper.HobbieMapper
import com.anand.industries.kotlingraphql.rest.person.HobbieRepository
import org.springframework.stereotype.Component

@Component
class HobbieService(private val hobbieRepository: HobbieRepository) {

    fun getHobbieById(id: Int): HobbieModel {
        val hobbie = hobbieRepository.findById(id).get()
        return HobbieMapper.map(hobbie)
    }

    fun getHobbiesByIds(id: List<Int>) = hobbieRepository.findAllById(id)
}
