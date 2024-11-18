package com.buddamanse.seairline.home.repository

import com.buddamanse.seairline.home.dto.SenderDTO
import com.buddamanse.seairline.home.entity.Sender
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface SenderRepository : JpaRepository<Sender, UUID> {
    fun findByCustomId(customId: String): Optional<SenderDTO>
}