package com.buddamanse.seairline.schedule.dto

import com.buddamanse.seairline.home.entity.Region

data class AirportDTO (
    val name: String,
    var region: Region
)