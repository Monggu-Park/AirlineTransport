package com.buddamanse.seairline.home.dto

import java.util.UUID

data class SenderDTO (
    val id: UUID ?= null,
    val customId: String,
    val name: String,
    val address: String,
    val phoneNumber: String
)