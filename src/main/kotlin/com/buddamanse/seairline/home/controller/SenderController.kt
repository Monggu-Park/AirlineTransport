package com.buddamanse.seairline.home.controller

import com.buddamanse.seairline.home.dto.SenderDTO
import com.buddamanse.seairline.home.entity.Sender
import com.buddamanse.seairline.home.service.SenderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/senders")
class SenderController (
    private val senderService: SenderService
){
    @GetMapping("/")
    fun getSender(@RequestParam customId: String): ResponseEntity<SenderDTO> {
        val getSender = senderService.getSender(customId)
        return ResponseEntity(getSender, HttpStatus.OK)
    }
    @PostMapping("/register")
    fun createSender(@RequestBody senderDTO: SenderDTO): ResponseEntity<Sender> {
        val createdSender = senderService.createSender(senderDTO)
        return ResponseEntity(createdSender, HttpStatus.CREATED)
    }
}