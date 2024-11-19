package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.entity.Plane
import com.buddamanse.seairline.schedule.repository.PlaneRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PlaneService (
    private val planeRepository: PlaneRepository
){
    fun getAllPlanes(airlineId: UUID) : List<Plane> {
        return planeRepository.findAllByAirlineId(airlineId)
    }
}