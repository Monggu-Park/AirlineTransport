package com.buddamanse.seairline.home.service

import com.buddamanse.seairline.home.dto.SenderDTO
import com.buddamanse.seairline.home.entity.Sender
import com.buddamanse.seairline.home.repository.SenderRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class SenderService (
    private val senderRepository: SenderRepository
) {
    fun getSender(customId: String): Sender {
        return senderRepository.findByCustomId(customId).orElseThrow {
            throw IllegalArgumentException("$customId not found")
        }
    }
    @Transactional
   fun createSender(senderDTO: SenderDTO): Sender {
       val sender = Sender(
           customId = senderDTO.customId,
           name = senderDTO.name,
           address = senderDTO.address,
           phoneNumber = senderDTO.phoneNumber
       )
       return senderRepository.save(sender)
   }
}