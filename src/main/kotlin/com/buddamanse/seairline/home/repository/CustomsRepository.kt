package com.buddamanse.seairline.home.repository

import com.buddamanse.seairline.home.entity.Customs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID
@Repository
interface CustomsRepository : JpaRepository<Customs, UUID> {
}