package com.buddamanse.seairline.home.service

import com.buddamanse.seairline.home.dto.CustomsDTO
import com.buddamanse.seairline.home.dto.CustomsEmployeeDTO
import com.buddamanse.seairline.home.entity.Customs
import com.buddamanse.seairline.home.entity.CustomsEmployee
import com.buddamanse.seairline.home.entity.Region
import com.buddamanse.seairline.home.repository.CustomsEmployeeRepository
import com.buddamanse.seairline.home.repository.CustomsRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomsService (
    private val customsRepository: CustomsRepository,
    private val customsEmployeeRepository: CustomsEmployeeRepository
) {
    fun getAllCustoms(): List<Customs> {
        return customsRepository.findAll()
    }
    fun getAllCustomsEmployee(): List<CustomsEmployee> {
        return customsEmployeeRepository.findAll()
    }
    fun getCustomsEmployee(customId: String): CustomsEmployee {
        return customsEmployeeRepository.findByCustomId(customId)
    }
    @Transactional
    fun registerCustoms(customsDTO: CustomsDTO): Customs {
        val registered = Customs(
            region = customsDTO.region
        )
        return customsRepository.save(registered)
    }
    @Transactional
    fun registerCustomsEmployee(customsEmployeeDTO: CustomsEmployeeDTO): CustomsEmployee {
        val customs = customsRepository.findById(customsEmployeeDTO.customsId)
            .orElseThrow{ IllegalArgumentException("Customs not found with id: ${customsEmployeeDTO.customId}") }
        val registered = CustomsEmployee(
            customId = customsEmployeeDTO.customId,
            name = customsEmployeeDTO.name,
            customs = customs
        )
        return customsEmployeeRepository.save(registered)
    }
}