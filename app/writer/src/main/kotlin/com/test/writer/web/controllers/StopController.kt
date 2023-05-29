package com.test.writer.web.controllers

import com.test.writer.entities.Stop
import com.test.writer.entities.dto.StopDTO
import com.test.writer.service.RouteService
import com.test.writer.service.StopService;
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/stops")
class StopController(
        private val service: StopService,
        private val routeService: RouteService
){

    @PostMapping
    fun create(@RequestBody inputDTO: StopDTO): ResponseEntity<Stop> {
        val route = routeService.getById(inputDTO.routeId) ?: throw RuntimeException("route not found")
        val createdEntity = service.addStopInRoute(inputDTO, route)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity)
    }
}