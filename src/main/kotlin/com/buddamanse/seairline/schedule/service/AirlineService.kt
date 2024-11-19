package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.entity.Airline
import com.buddamanse.seairline.schedule.repository.AirlineRepository
import org.springframework.stereotype.Service

@Service
class AirlineService (
    private val airlineRepository: AirlineRepository
){
    fun getAllAirlines(): List<Airline> {
        return airlineRepository.findAll()
    }
}