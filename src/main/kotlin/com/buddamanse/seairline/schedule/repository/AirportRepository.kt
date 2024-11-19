package com.buddamanse.seairline.schedule.repository

import com.buddamanse.seairline.schedule.entity.Airport
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AirportRepository : JpaRepository<Airport, UUID> {

}