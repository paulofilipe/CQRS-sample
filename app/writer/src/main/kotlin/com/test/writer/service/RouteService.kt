package com.test.writer.service

import com.test.writer.entities.Route
import com.test.writer.entities.repositories.RouteRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class RouteService(
        private val stopService: StopService,
        routeRepository: RouteRepository
) : GenericService<Route, RouteRepository>(routeRepository) {

    override fun setId(entity: Route, id: Long): Route {
        return entity.copy(id = id)
    }

    override fun validateCreation(entity: Route) {
        if (entity.stops.size < 1) {
            throw RuntimeException("A route must have at least one stop")
        }

        entity.stops.forEach { stopService.validateCreation(it) }
    }
}