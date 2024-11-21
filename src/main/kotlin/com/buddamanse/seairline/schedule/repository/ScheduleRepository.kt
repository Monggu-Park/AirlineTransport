package com.buddamanse.seairline.schedule.repository

import com.buddamanse.seairline.schedule.entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID
@Repository
interface ScheduleRepository : JpaRepository<Schedule, UUID> {
    fun findAllByAirlineEmployeesId(employeeId: UUID): List<Schedule>
}