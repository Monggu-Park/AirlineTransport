package com.buddamanse.seairline.schedule.repository

import com.buddamanse.seairline.schedule.entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ScheduleRepository : JpaRepository<Schedule, UUID> {
}