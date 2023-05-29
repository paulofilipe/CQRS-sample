package com.test.writer.web.controllers

import com.test.writer.entities.Route
import com.test.writer.service.RouteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/routes")
class RouteController(private val service: RouteService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Route> {
        val entity = service.getById(id)
        return if (entity != null) {
            ResponseEntity.ok(entity)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Route>> {
        val entities = service.getAll()
        return ResponseEntity.ok(entities)
    }

    @PostMapping
    fun create(@RequestBody entity: Route): ResponseEntity<Route> {
        val createdEntity = service.create(entity)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updatedEntity: Route): ResponseEntity<Route> {
        val updated = service.update(id, updatedEntity)
        return if (updated != null) {
            ResponseEntity.ok(updated)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
