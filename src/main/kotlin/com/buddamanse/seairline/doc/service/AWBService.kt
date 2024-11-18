package com.buddamanse.seairline.doc.service

import com.buddamanse.seairline.doc.dto.AWBDTO
import com.buddamanse.seairline.doc.entity.AWB
import com.buddamanse.seairline.doc.repository.AWBRepository
import com.buddamanse.seairline.home.repository.SenderRepository
import org.springframework.stereotype.Service

@Service
class AWBService (
    private val awbRepository: AWBRepository,
    private val senderRepository: SenderRepository
){
    fun createAWB(awbdto: AWBDTO): AWB {
        val awb = AWB(
            sender = awbdto.sender,
            cargo = awbdto.cargo,
            schedule = awbdto.schedule,
            receiverName = awbdto.receiverName,
            receiverAddress = awbdto.receiverAddress,
            receiverTel = awbdto.receiverTel,
            isValid = awbdto.isValid,
            createdAt = awbdto.createdAt
        )
        return awbRepository.save(awb)
    }

    fun getAWB(customId: String): AWBDTO {
        return awbRepository.findAWBBySender_CustomId(customId).orElseThrow {
            throw IllegalArgumentException("$customId never wrote AWB")
        }
    }
}