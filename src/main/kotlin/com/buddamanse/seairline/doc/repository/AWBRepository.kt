package com.buddamanse.seairline.doc.repository

import com.buddamanse.seairline.doc.dto.AWBDTO
import com.buddamanse.seairline.doc.entity.AWB
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface AWBRepository: JpaRepository<AWB, UUID> {
    fun findAWBBySender_CustomId(customId: String): List<AWB>
}