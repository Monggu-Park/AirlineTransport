package com.buddamanse.seairline.schedule.controller

import com.buddamanse.seairline.doc.entity.AWB
import com.buddamanse.seairline.doc.service.AWBService
import com.buddamanse.seairline.schedule.dto.ScheduleDTO
import com.buddamanse.seairline.schedule.entity.Schedule
import com.buddamanse.seairline.schedule.service.ScheduleService
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
@RequestMapping("/api/v1/schedule")
class ScheduleController (
    private val scheduleService: ScheduleService,
    private val awbService: AWBService
){
    @GetMapping("/")
    fun getAllSchedule(): ResponseEntity<List<Schedule>> {
        val schedules = scheduleService.getAllSchedule()
        return ResponseEntity(schedules, HttpStatus.OK)
    }

    @PostMapping("/register")
    fun registerSchedule(@RequestParam awbId: UUID, @RequestBody scheduleDTO: ScheduleDTO): ResponseEntity<AWB> {
        val schedule = scheduleService.registerSchedule(scheduleDTO)
        val assigned = awbService.assignSchedule(awbId, schedule)
        return ResponseEntity(assigned, HttpStatus.CREATED)
    }
    @GetMapping("/employee-worked")
    fun getEmployeeWorkedSchedule(@RequestParam employeeId: UUID): ResponseEntity<List<Schedule>> {
        val schedules = scheduleService.getAllScheduleByEmployeeId(employeeId)
        return ResponseEntity(schedules, HttpStatus.OK)
    }

}