package com.buddamanse.seairline.schedule.dto

import com.buddamanse.seairline.schedule.entity.AirlineEmployees
import com.buddamanse.seairline.schedule.entity.Airport
import com.buddamanse.seairline.schedule.entity.Plane
import java.time.LocalDateTime
import java.util.UUID

data class ScheduleDTO (
    var planeId: UUID,
    var departureAirportId: UUID,
    var arrivalAirportId: UUID,
    var departureTime: LocalDateTime,
    var arrivalTime: LocalDateTime,
    var airlineEmployeesId: UUID,
    var createdDateTime: LocalDateTime
)