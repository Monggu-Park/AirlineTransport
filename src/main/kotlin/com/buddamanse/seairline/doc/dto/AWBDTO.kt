package com.buddamanse.seairline.doc.dto

import com.buddamanse.seairline.home.dto.CargoDTO
import com.buddamanse.seairline.home.entity.Cargo
import com.buddamanse.seairline.home.entity.Sender
import com.buddamanse.seairline.schedule.entity.Schedule
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType
import java.time.LocalDateTime
import java.util.UUID

data class AWBDTO (
    var senderId: String,
    var cargo: CargoDTO,
    var receiverName: String,
    var receiverAddress: String,
    var receiverTel: String,
)