package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.dto.PlaneDTO
import com.buddamanse.seairline.schedule.entity.Plane
import com.buddamanse.seairline.schedule.repository.AirlineRepository
import com.buddamanse.seairline.schedule.repository.PlaneRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class PlaneService (
    private val planeRepository: PlaneRepository,
    private val airlineRepository: AirlineRepository
){
    fun getAllPlanes(airlineId: String) : List<Plane> {
        val airlineIdUUID = UUID.fromString(airlineId)
        return planeRepository.findAllByAirlineId(airlineIdUUID)
    }

    @Transactional
    fun registerPlane(planeDTO: PlaneDTO): Plane {
        val airline = airlineRepository.findById(planeDTO.airlineId).orElseThrow()
        val registered = Plane(
            airline = airline
        )
        return planeRepository.save(registered)
    }
}