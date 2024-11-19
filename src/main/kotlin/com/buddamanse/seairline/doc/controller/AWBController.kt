package com.buddamanse.seairline.doc.controller

import com.buddamanse.seairline.doc.dto.AWBDTO
import com.buddamanse.seairline.doc.entity.AWB
import com.buddamanse.seairline.doc.service.AWBService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/awb")
class AWBController (
    private val awbService: AWBService
){
    @GetMapping("/")
    fun getAllAWB(): ResponseEntity<List<AWB>> {
        val awbs = awbService.getAllAWB()
        return ResponseEntity(awbs, HttpStatus.OK)
    }

    @GetMapping("/")
    fun getAWB(@RequestParam customId: String): ResponseEntity<AWB> {
        val getAWB = awbService.getAWB(customId)
        return ResponseEntity(getAWB, HttpStatus.OK)
    }

    @PostMapping("/create")
    fun createAWB(@RequestBody awbdto: AWBDTO): ResponseEntity<AWB> {
        val createdAWB = awbService.createAWB(awbdto)
        return ResponseEntity(createdAWB, HttpStatus.CREATED)
    }
}