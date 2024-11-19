package com.buddamanse.seairline.schedule.repository

import com.buddamanse.seairline.schedule.entity.Airline
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AirlineRepository : JpaRepository<Airline, UUID>{

}