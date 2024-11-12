package com.buddamanse.seairline.home.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "sender")
data class Sender (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val address: String,
    @Column(nullable = false)
    val phoneNumber: String
)