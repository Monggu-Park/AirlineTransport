package com.buddamanse.seairline.doc.service

import com.buddamanse.seairline.doc.dto.AWBDTO
import com.buddamanse.seairline.doc.entity.AWB
import com.buddamanse.seairline.doc.repository.AWBRepository
import com.buddamanse.seairline.home.repository.SenderRepository
import com.buddamanse.seairline.schedule.entity.Schedule
import org.springframework.stereotype.Service
import java.util.*

@Service
class AWBService(
    private val awbRepository: AWBRepository,
){
    fun createAWB(awbdto: AWBDTO): AWB {
        val awb = AWB(
            sender = awbdto.sender,
            cargo = awbdto.cargo,
            schedule = null,
            receiverName = awbdto.receiverName,
            receiverAddress = awbdto.receiverAddress,
            receiverTel = awbdto.receiverTel,
            isValid = false,
            createdAt = awbdto.createdAt
        )
        return awbRepository.save(awb)
    }

    fun assignSchedule(id: UUID, schedule: Schedule): AWB {
        val awb = awbRepository.findById(id).orElseThrow{
            throw IllegalArgumentException("AWB not found")
        }
        awb.schedule = schedule
        awb.isValid = true
        return awbRepository.save(awb)
    }
    fun getAllAWB(): List<AWB> {
        return awbRepository.findAll()
    }

    fun getAWB(customId: String): AWB {
        return awbRepository.findAWBBySender_CustomId(customId).orElseThrow {
            throw IllegalArgumentException("$customId never wrote AWB")
        }
    }
}