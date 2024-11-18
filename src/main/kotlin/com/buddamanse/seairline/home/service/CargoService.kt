package com.buddamanse.seairline.home.service

import com.buddamanse.seairline.home.dto.CargoDTO
import com.buddamanse.seairline.home.entity.Cargo
import com.buddamanse.seairline.home.repository.CargoRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CargoService (
    private val cargoRepository: CargoRepository
){
    fun registerCargo(cargoDTO: CargoDTO): Cargo {
        val cargo = Cargo(
            description = cargoDTO.description,
            status = cargoDTO.status,
            weight = cargoDTO.weight,
            width = cargoDTO.width,
            height = cargoDTO.height
        )
        return cargoRepository.save(cargo)
    }

    fun getCargo(id: UUID): CargoDTO {
        return cargoRepository.findCargoById(id).orElseThrow{
            throw IllegalArgumentException(" Cargo not found. ")
        }
    }
}