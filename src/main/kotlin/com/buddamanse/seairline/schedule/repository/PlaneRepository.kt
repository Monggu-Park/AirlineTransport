package com.buddamanse.seairline.schedule.repository

import com.buddamanse.seairline.schedule.entity.Airline
import com.buddamanse.seairline.schedule.entity.Plane
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlaneRepository : JpaRepository<Plane, UUID> {
    fun findAllByAirlineId(airlineId: UUID): List<Plane>
}