package com.buddamanse.seairline.schedule.controller

import com.buddamanse.seairline.schedule.dto.AirlineEmployeeDTO
import com.buddamanse.seairline.schedule.entity.Airline
import com.buddamanse.seairline.schedule.entity.AirlineEmployees
import com.buddamanse.seairline.schedule.entity.Airport
import com.buddamanse.seairline.schedule.entity.Plane
import com.buddamanse.seairline.schedule.service.AirlineEmployeesService
import com.buddamanse.seairline.schedule.service.AirlineService
import com.buddamanse.seairline.schedule.service.AirportService
import com.buddamanse.seairline.schedule.service.PlaneService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@RestController
@RequestMapping("/api/v1/airline")
class AirlineController (
    private val airlineEmployeesService: AirlineEmployeesService,
    private val airlineService: AirlineService,
    private val airportService: AirportService,
    private val planeService: PlaneService
) {
    @GetMapping("/")
    fun getAllAirline(): ResponseEntity<List<Airline>> {
        val airlines = airlineService.getAllAirlines()
        return ResponseEntity(airlines, HttpStatus.OK)
    }
    @GetMapping("/planes")
    fun getPlane(@RequestParam airlineId: UUID): ResponseEntity<List<Plane>> {
        val planes = planeService.getAllPlanes(airlineId)
        return ResponseEntity(planes, HttpStatus.OK)
    }
    @GetMapping("/airports")
    fun getAirport(): ResponseEntity<List<Airport>> {
        val airports = airportService.getAllAirport()
        return ResponseEntity(airports, HttpStatus.OK)
    }
    @GetMapping("/employee/login")
    fun loginEmployee(@RequestParam customId: String): ResponseEntity<AirlineEmployees> {
        val airlineEmployees = airlineEmployeesService.getEmployee(customId)
        return ResponseEntity(airlineEmployees, HttpStatus.OK)
    }

    @PostMapping("/employee/register")
    fun registerEmployee(@RequestBody airlineEmployeeDTO: AirlineEmployeeDTO): ResponseEntity<AirlineEmployees> {
        val registered = airlineEmployeesService.registerEmployee(airlineEmployeeDTO)
        return ResponseEntity(registered, HttpStatus.CREATED)
    }
}