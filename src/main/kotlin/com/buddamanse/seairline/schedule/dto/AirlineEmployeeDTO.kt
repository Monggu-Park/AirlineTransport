package com.buddamanse.seairline.schedule.dto

import com.buddamanse.seairline.schedule.entity.Airline
import com.buddamanse.seairline.schedule.entity.Role
import java.util.UUID

data class AirlineEmployeeDTO (
    var customId: String,
    var name: String,
    var airlineId: UUID,
    var role: Role
)