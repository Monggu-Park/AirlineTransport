package com.buddamanse.seairline.home.dto

import com.buddamanse.seairline.home.entity.CargoStatus

data class CargoDTO (
    val description: String,
    val weight: Double,
    val width: Double,
    val height: Double
)