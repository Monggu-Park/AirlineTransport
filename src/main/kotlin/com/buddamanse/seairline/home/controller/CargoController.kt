package com.buddamanse.seairline.home.controller

import com.buddamanse.seairline.home.dto.CargoDTO
import com.buddamanse.seairline.home.entity.Cargo
import com.buddamanse.seairline.home.entity.CargoStatus
import com.buddamanse.seairline.home.service.CargoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/cargo")
class CargoController (
    private val cargoService: CargoService
){
    @GetMapping("/")
    fun getAllCargo(): ResponseEntity<List<Cargo>> {
        val cargos = cargoService.getAllCargo()
        return ResponseEntity(cargos, HttpStatus.OK)
    }

    @PostMapping("/register")
    fun registerCargo(@RequestBody cargoDTO: CargoDTO): ResponseEntity<Cargo> {
        val registeredCargo = cargoService.registerCargo(cargoDTO)
        return ResponseEntity(registeredCargo, HttpStatus.CREATED)
    }

    @PostMapping("/changeStatus")
    fun changeStatus(@RequestParam cargoId: UUID, @RequestParam cargoStatus: CargoStatus): ResponseEntity<Cargo> {
        val changedCargo = cargoService.changeStatus(cargoId, cargoStatus)
        return ResponseEntity(changedCargo, HttpStatus.OK)
    }
}