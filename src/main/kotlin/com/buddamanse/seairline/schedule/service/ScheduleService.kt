package com.buddamanse.seairline.schedule.service

import com.buddamanse.seairline.schedule.dto.ScheduleDTO
import com.buddamanse.seairline.schedule.entity.Schedule
import com.buddamanse.seairline.schedule.repository.AirlineEmployeesRepository
import com.buddamanse.seairline.schedule.repository.AirportRepository
import com.buddamanse.seairline.schedule.repository.PlaneRepository
import com.buddamanse.seairline.schedule.repository.ScheduleRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ScheduleService (
    private val planeRepository: PlaneRepository,
    private val airportRepository: AirportRepository,
    private val airlineEmployeesRepository: AirlineEmployeesRepository,
    private val scheduleRepository: ScheduleRepository
) {
    fun getAllSchedule(): List<Schedule> {
        return scheduleRepository.findAll()
    }

    fun getSchedule(scheduleId: UUID): Schedule {
        return scheduleRepository.findById(scheduleId).orElseThrow {
            throw IllegalArgumentException("No Such Schedule")
        }
    }

    fun registerSchedule(scheduleDTO: ScheduleDTO): Schedule {
        val plane = planeRepository.findById(scheduleDTO.planeId)
            .orElseThrow{ IllegalArgumentException("Plane not found with id: ${scheduleDTO.planeId}") }
        val departureAirport = airportRepository.findById(scheduleDTO.departureAirportId)
            .orElseThrow{ IllegalArgumentException("Departure airport not found with id: ${scheduleDTO.departureAirportId}") }
        val arrivalAirport = airportRepository.findById(scheduleDTO.arrivalAirportId)
            .orElseThrow { IllegalArgumentException("Arrival airport not found with id: ${scheduleDTO.arrivalAirportId}") }
        val airlineEmployees = airlineEmployeesRepository.findById(scheduleDTO.airlineEmployeesId)
            .orElseThrow { IllegalArgumentException("Airline employees not found with id: ${scheduleDTO.airlineEmployeesId}") }

        val schedule = Schedule(
            plane = plane,
            departureAirport = departureAirport,
            arrivalAirport = arrivalAirport,
            departureTime = scheduleDTO.departureTime,
            arrivalTime = scheduleDTO.arrivalTime,
            airlineEmployees = airlineEmployees,
            createdDateTime = LocalDateTime.now()
        )

        return scheduleRepository.save(schedule)
    }

}