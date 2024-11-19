package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.dto.AirlineEmployeeDTO
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

    fun getEmployee(customId: String): AirlineEmployees {
        return airlineEmployeesRepository.findByCustomId(customId)
    }

    fun registerEmployee(airlineEmployeeDTO: AirlineEmployeeDTO): AirlineEmployees {
        val employee = AirlineEmployees(
            customId = airlineEmployeeDTO.customId,
            name = airlineEmployeeDTO.name,
            airline = airlineEmployeeDTO.airline,
            role = airlineEmployeeDTO.role
        )
        return airlineEmployeesRepository.save(employee)
    }
}