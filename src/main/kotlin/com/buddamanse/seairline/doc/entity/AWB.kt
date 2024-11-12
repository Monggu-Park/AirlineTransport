package com.buddamanse.seairline.doc.entity

import com.buddamanse.seairline.home.entity.Sender
import jakarta.persistence.*
import java.util.UUID

@Entity
class AWB(senderId: UUID) {
    @Id
    var id: UUID = UUID.randomUUID()

    @Column
    var senderId: UUID = sender.id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    lateinit var sender: Sender

}