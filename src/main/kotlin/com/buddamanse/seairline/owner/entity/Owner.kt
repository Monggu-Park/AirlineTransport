package com.buddamanse.seairline.owner.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "owner")
data class Owner (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val name: String
)