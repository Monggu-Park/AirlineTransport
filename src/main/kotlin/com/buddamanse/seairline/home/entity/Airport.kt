package com.buddamanse.seairline.home.entity

import jakarta.persistence.*
import java.util.UUID
@Entity
data class Airport (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var region: Region
)
