package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.dto.AirportDTO
import com.buddamanse.seairline.schedule.entity.Airport
import com.buddamanse.seairline.schedule.repository.AirportRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AirportService (
    private val airportRepository: AirportRepository
){
    fun getAllAirport() : List<Airport> {
        return airportRepository.findAll()
    }
    @Transactional
    fun registerAirport(airportDTO: AirportDTO): Airport {
        val registered = Airport(
            name = airportDTO.name,
            region = airportDTO.region
        )
        return airportRepository.save(registered)
    }
}