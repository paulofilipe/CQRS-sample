package com.test.writer.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.test.writer.entities.enuns.StopStatus
import javax.persistence.*

@Entity
@Table(name = "stops",schema="delivery_service")
data class Stop(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        override val id: Long = 0,

        @Column(name = "description")
        val description: String,

        @Column(name = "address")
        val address: String,

        @Column(name = "latitude")
        val latitude: Double,

        @Column(name = "longitude")
        val longitude: Double,

        @Enumerated(EnumType.STRING)
        @Column(name = "stop_stat")
        val status: StopStatus,

        @Column(name = "delivery_radius")
        val deliveryRadius: Int,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "route_id")
        @JsonBackReference
        val route: Route?

) : BaseEntity