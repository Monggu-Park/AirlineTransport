package com.buddamanse.seairline.home.entity

import jakarta.persistence.*
import java.util.UUID
@Entity
data class CustomsEmployee (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    var customId: String,

    @Column(nullable = false)
    var name: String,

    @ManyToOne
    @JoinColumn(nullable = false)
    var customs: Customs
)