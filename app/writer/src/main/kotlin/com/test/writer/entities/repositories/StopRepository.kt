package com.test.writer.entities.repositories

import com.test.writer.entities.Stop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StopRepository : JpaRepository<Stop, Long>
