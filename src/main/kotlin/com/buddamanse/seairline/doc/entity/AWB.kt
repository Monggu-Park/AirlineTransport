package com.buddamanse.seairline.doc.entity

import com.buddamanse.seairline.owner.entity.Owner
import jakarta.persistence.*
import java.util.UUID

@Entity
class AWB(ownerId: UUID) {
    @Id
    var id: UUID = UUID.randomUUID()

    @Column
    var ownerId: UUID = owner.id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId")
    lateinit var owner: Owner

}