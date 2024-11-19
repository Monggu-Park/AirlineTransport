package com.buddamanse.seairline.home.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
data class Customs (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val region: Region
)

enum class Region { Incheon, Jeju, Kimhae, Beijing, Tokyo}