package com.buddamanse.seairline.home.repository

import com.buddamanse.seairline.home.dto.CargoDTO
import com.buddamanse.seairline.home.entity.Cargo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface CargoRepository : JpaRepository<Cargo, UUID> {
    fun findCargoById(id: UUID): Optional<Cargo>
}