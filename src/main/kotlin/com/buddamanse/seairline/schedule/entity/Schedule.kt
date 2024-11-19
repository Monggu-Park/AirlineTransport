package com.buddamanse.seairline.schedule.entity

import jakarta.persistence.*
import jdk.jfr.Timestamp
import java.time.LocalDateTime
import java.util.UUID
@Entity
data class Schedule (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(nullable = false)
    var plane: Plane,

    @ManyToOne
    @JoinColumn(nullable = false, name = "departure_airport_id")
    var departureAirport: Airport,

    @ManyToOne
    @JoinColumn(nullable = false, name = "arrival_airport_id")
    var arrivalAirport: Airport,

    @Column(nullable = false)
    var departureTime: LocalDateTime,

    @Column(nullable = false)
    var arrivalTime: LocalDateTime,

    @OneToOne
    @JoinColumn(nullable = false)
    var airlineEmployees: AirlineEmployees,

    @Column(nullable = false)
    @Timestamp
    var createdDateTime: LocalDateTime
)