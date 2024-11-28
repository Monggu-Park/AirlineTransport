package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.dto.AirlineDTO
import com.buddamanse.seairline.schedule.entity.Airline
import com.buddamanse.seairline.schedule.repository.AirlineRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AirlineService (
    private val airlineRepository: AirlineRepository
){
    fun getAllAirlines(): List<Airline> {
        return airlineRepository.findAll()
    }

    @Transactional
    fun registerAirline(airlineDTO: AirlineDTO): Airline {
        val registered = Airline(
            name = airlineDTO.name
        )
        return airlineRepository.save(registered)
    }
}