package com.buddamanse.seairline.schedule.repository

import com.buddamanse.seairline.schedule.entity.AirlineEmployees
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AirlineEmployeesRepository :JpaRepository<AirlineEmployees, UUID> {
    fun findAllByAirlineId(airlineId: UUID): List<AirlineEmployees>
}