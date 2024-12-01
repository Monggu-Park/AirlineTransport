package com.buddamanse.seairline.doc.service

import com.buddamanse.seairline.doc.dto.AWBDTO
import com.buddamanse.seairline.doc.entity.AWB
import com.buddamanse.seairline.doc.repository.AWBRepository
import com.buddamanse.seairline.home.repository.SenderRepository
import com.buddamanse.seairline.home.service.CargoService
import com.buddamanse.seairline.schedule.entity.Schedule
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class AWBService(
    private val awbRepository: AWBRepository,
    private val senderRepository: SenderRepository,
    private val cargoService: CargoService,
){
    @Transactional
    fun createAWB(awbDto: AWBDTO): AWB {
        val sender = senderRepository.findByCustomId(awbDto.senderId).orElseThrow()
        val cargo = cargoService.registerCargo(awbDto.cargo)
        val awb = AWB(
            sender = sender,
            cargo = cargo,
            schedule = null,
            receiverName = awbDto.receiverName,
            receiverAddress = awbDto.receiverAddress,
            receiverTel = awbDto.receiverTel,
            isValid = false,
            createdAt = LocalDateTime.now()
        )
        return awbRepository.save(awb)
    }

    @Transactional
    fun assignSchedule(id: String, schedule: Schedule): AWB {
        val idToUUID = UUID.fromString(id)
        val awb = awbRepository.findById(idToUUID).orElseThrow{
            throw IllegalArgumentException("AWB not found")
        }
        awb.schedule = schedule
        awb.isValid = true
        return awb
    }
    fun getAllAWB(): List<AWB> {
        return awbRepository.findAll()
    }

    fun getAWB(customId: String): List<AWB> {
        return awbRepository.findAWBBySender_CustomId(customId)
    }
}