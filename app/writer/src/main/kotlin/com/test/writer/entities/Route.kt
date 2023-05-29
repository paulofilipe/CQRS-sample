package com.test.writer.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.test.writer.entities.enuns.RouteStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "route",schema="delivery_service")
data class Route (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        override val id: Long = 0,

        @Column(name = "route_date")
        val date: LocalDateTime,

        @Enumerated(EnumType.STRING)
        @Column(name = "route_stat")
        val status: RouteStatus,

        @OneToMany(mappedBy = "route", cascade = [CascadeType.ALL], orphanRemoval = true)
        @JsonManagedReference
        val stops: MutableList<Stop> = mutableListOf()
) : BaseEntity