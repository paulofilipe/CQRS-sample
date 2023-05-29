package com.test.writer.entities.dto

import com.test.writer.entities.enuns.StopStatus

class StopDTO (
    val description: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val status: StopStatus,
    val deliveryRadius: Int,
    val routeId: Long
)