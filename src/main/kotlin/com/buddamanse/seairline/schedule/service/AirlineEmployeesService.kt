package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.dto.AirlineEmployeeDTO
import com.buddamanse.seairline.schedule.entity.AirlineEmployees
import com.buddamanse.seairline.schedule.repository.AirlineEmployeesRepository
import com.buddamanse.seairline.schedule.repository.AirlineRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AirlineEmployeesService (
    private val airlineEmployeesRepository: AirlineEmployeesRepository,
    private val airlineRepository: AirlineRepository
){
    fun getAllEmployees(airlineId: UUID): List<AirlineEmployees> {
        return airlineEmployeesRepository.findAllByAirlineId(airlineId)
    }

    fun getEmployee(customId: String): AirlineEmployees {
        return airlineEmployeesRepository.findByCustomId(customId)
    }
    @Transactional
    fun registerEmployee(airlineEmployeeDTO: AirlineEmployeeDTO): AirlineEmployees {
        val airline = airlineRepository.findById(airlineEmployeeDTO.airlineId).orElseThrow()

        val employee = AirlineEmployees(
            customId = airlineEmployeeDTO.customId,
            name = airlineEmployeeDTO.name,
            airline = airline,
            role = airlineEmployeeDTO.role
        )
        return airlineEmployeesRepository.save(employee)
    }
}