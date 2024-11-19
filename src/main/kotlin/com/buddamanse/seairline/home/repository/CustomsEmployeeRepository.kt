package com.buddamanse.seairline.home.repository

import com.buddamanse.seairline.home.entity.CustomsEmployee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID
@Repository
interface CustomsEmployeeRepository : JpaRepository<CustomsEmployee, UUID> {
    fun findByCustomId(customId: String): CustomsEmployee
    fun findAllByCustomsId(customsId: UUID): List<CustomsEmployee>
}