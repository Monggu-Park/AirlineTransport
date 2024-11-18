package com.buddamanse.seairline.doc.repository

import com.buddamanse.seairline.doc.entity.AWB
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AWBRepository: JpaRepository<AWB, String> {
}