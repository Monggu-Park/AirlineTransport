package com.buddamanse.seairline.schedule.dto

import com.buddamanse.seairline.schedule.entity.AirlineEmployees
import com.buddamanse.seairline.schedule.entity.Airport
import com.buddamanse.seairline.schedule.entity.Plane
import java.time.LocalDateTime

data class ScheduleDTO (
    var plane: Plane,
    var departureAirport: Airport,
    var arrivalAirport: Airport,
    var departureTime: LocalDateTime,
    var arrivalTime: LocalDateTime,
    var airlineEmployees: AirlineEmployees,
    var createdDateTime: LocalDateTime
)