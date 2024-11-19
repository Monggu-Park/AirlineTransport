package com.buddamanse.seairline.home.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "cargo")
data class Cargo (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID = UUID.randomUUID(),

    @Column(nullable = true)
    val description: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: CargoStatus,

    @Column(nullable = false)
    val weight: Double,

    @Column(nullable = false)
    val width: Double,

    @Column(nullable = false)
    val height: Double,
)

enum class CargoStatus { Approved, Reject, Waiting }