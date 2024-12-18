package com.buddamanse.seairline.schedule.entity

import jakarta.persistence.*
import java.util.UUID
@Entity
data class AirlineEmployees (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    var customId: String,

    @Column(nullable = false)
    var name: String,

    @ManyToOne
    @JoinColumn(nullable = false)
    var airline: Airline,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: Role
)

enum class Role { Administrator, Captain }