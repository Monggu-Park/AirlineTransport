package com.buddamanse.seairline.home.service

import com.buddamanse.seairline.home.dto.CargoDTO
import com.buddamanse.seairline.home.entity.Cargo
import com.buddamanse.seairline.home.entity.CargoStatus
import com.buddamanse.seairline.home.repository.CargoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CargoService (
    private val cargoRepository: CargoRepository
){
    @Transactional
    fun registerCargo(cargoDTO: CargoDTO): Cargo {
        val cargo = Cargo(
            description = cargoDTO.description,
            status = CargoStatus.Waiting,
            weight = cargoDTO.weight,
            width = cargoDTO.width,
            height = cargoDTO.height
        )
        return cargoRepository.save(cargo)
    }

    @Transactional
    fun changeStatus(cargoId: String, cargoStatus: CargoStatus): Cargo {
        val cargoIdUUID = UUID.fromString(cargoId)
        val cargo = getCargo(cargoIdUUID)
        cargo.status = cargoStatus
        return cargo
    }

    fun getAllCargo(): List<Cargo> {
        return cargoRepository.findAll()
    }

    fun getCargo(id: UUID): Cargo {
        return cargoRepository.findCargoById(id).orElseThrow{
            throw IllegalArgumentException(" Cargo not found. ")
        }
    }
}