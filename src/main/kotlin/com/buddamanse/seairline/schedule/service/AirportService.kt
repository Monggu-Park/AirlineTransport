package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.entity.Airport
import com.buddamanse.seairline.schedule.repository.AirportRepository
import org.springframework.stereotype.Service

@Service
class AirportService (
    private val airportRepository: AirportRepository
){
    fun getAllAirport() : List<Airport> {
        return airportRepository.findAll()
    }
}