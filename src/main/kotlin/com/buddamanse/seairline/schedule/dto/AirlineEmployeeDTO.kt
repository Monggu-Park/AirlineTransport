package com.buddamanse.seairline.schedule.dto

import com.buddamanse.seairline.schedule.entity.Airline
import com.buddamanse.seairline.schedule.entity.Role

data class AirlineEmployeeDTO (
    var customId: String,
    var name: String,
    var airline: Airline,
    var role: Role
)