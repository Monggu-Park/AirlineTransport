package com.buddamanse.seairline.doc.entity

import com.buddamanse.seairline.home.entity.Cargo
import com.buddamanse.seairline.home.entity.Sender
import com.buddamanse.seairline.schedule.entity.Schedule
import jakarta.persistence.*
import jdk.jfr.Timestamp
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class AWB(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(nullable = false, name = "sender_id")
    var sender: Sender,

    @ManyToOne
    @JoinColumn(nullable = false)
    var cargo: Cargo,

    @OneToOne
    @JoinColumn(nullable = false)
    var schedule: Schedule,

    @Column(nullable = false)
    var receiverName: String,

    @Column(nullable = false)
    var receiverAddress: String,

    @Column(nullable = false)
    var receiverTel: String,

    @Column(nullable = false)
    var isValid: TinyIntJdbcType,

    @Column(nullable = false)
    @Timestamp
    var createdAt: LocalDateTime
)