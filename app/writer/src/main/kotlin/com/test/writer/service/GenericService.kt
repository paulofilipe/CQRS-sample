package com.test.writer.service

import com.test.writer.entities.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository

abstract class GenericService<T : BaseEntity, R : JpaRepository<T, Long>>(
        private val repository: R
) {
    abstract fun setId(entity: T, id: Long): T

    fun getById(id: Long): T? {
        return repository.findById(id).orElse(null)
    }

    fun create(entity: T): T {
        validateCreation(entity)
        return repository.save(entity)
    }

    abstract fun validateCreation(entity: T)

    fun update(id: Long, entity: T): T? {
        val existingEntity = repository.findById(id).orElse(null)
        if (existingEntity != null) {
            return repository.save(setId(entity, id))
        }
        return null
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    fun getAll(): List<T> {
        return repository.findAll()
    }

    private fun copyNonNullProperties(source: T, destination: T) {
        val sourceProperties = source.javaClass.declaredFields
        for (property in sourceProperties) {
            property.isAccessible = true
            val value = property.get(source)
            if (value != null) {
                property.set(destination, value)
            }
        }
    }
}