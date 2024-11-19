package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.entity.AirlineEmployees
import com.buddamanse.seairline.schedule.repository.AirlineEmployeesRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AirlineEmployeesService (
    private val airlineEmployeesRepository: AirlineEmployeesRepository
){
    fun getAllEmployees(airlineId: UUID): List<AirlineEmployees> {
        return airlineEmployeesRepository.findAllByAirlineId(airlineId)
    }
}