package com.buddamanse.seairline.home.controller

import com.buddamanse.seairline.home.dto.CustomsEmployeeDTO
import com.buddamanse.seairline.home.entity.Customs
import com.buddamanse.seairline.home.entity.CustomsEmployee
import com.buddamanse.seairline.home.service.CustomsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customs")
class CustomsController (
    private val customsService: CustomsService,
    private val cargoService: CustomsService
) {
    @GetMapping("/")
    fun getAllCustoms(): ResponseEntity<List<Customs>> {
        val customs = customsService.getAllCustoms()
        return ResponseEntity(customs, HttpStatus.OK)
    }
    @GetMapping("/employee")
    fun getAllCustomsEmployee(): ResponseEntity<List<CustomsEmployee>> {
        val customsEmployees = customsService.getAllCustomsEmployee()
        return ResponseEntity(customsEmployees, HttpStatus.OK)
    }
    @PostMapping("/employee/register")
    fun registerCustomsEmployee(@RequestBody customsEmployeeDTO: CustomsEmployeeDTO): ResponseEntity<CustomsEmployee> {
        val customsEmployee = customsService.registerCustomsEmployee(customsEmployeeDTO)
        return ResponseEntity(customsEmployee, HttpStatus.CREATED)
    }
    @GetMapping("/employee/login")
    fun loginEmployee(@RequestParam customId: String): ResponseEntity<CustomsEmployee> {
        val customsEmployee = customsService.getCustomsEmployee(customId)
        return ResponseEntity(customsEmployee, HttpStatus.OK)
    }
}