package com.test.writer.service

import com.test.writer.entities.Route
import com.test.writer.entities.Stop
import com.test.writer.entities.dto.StopDTO
import com.test.writer.entities.repositories.StopRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.math.BigDecimal.ZERO

@Service
class StopService(stopRepository: StopRepository) : GenericService<Stop, StopRepository>(stopRepository) {

    override fun setId(entity: Stop, id: Long): Stop {
        return entity.copy(id = id)
    }

    override fun validateCreation(entity: Stop) {
        if (ZERO.toDouble() == entity.latitude || ZERO.toDouble() == entity.longitude) {
            throw RuntimeException("invalid parameter latitude or longitude")
        }
    }

    fun addStopInRoute(inputDTO: StopDTO, route: Route): Stop {
        val stop = Stop(
                description = inputDTO.description,
                address = inputDTO.address,
                latitude = inputDTO.latitude,
                longitude = inputDTO.longitude,
                status = inputDTO.status,
                deliveryRadius = inputDTO.deliveryRadius,
                route = route
        )

        return this.create(stop)
    }
}