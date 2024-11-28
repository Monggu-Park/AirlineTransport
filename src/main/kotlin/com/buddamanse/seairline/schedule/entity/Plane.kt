package com.buddamanse.seairline.schedule.entity

import jakarta.persistence.*
import java.util.UUID
@Entity
data class Plane (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    val airline: Airline
)