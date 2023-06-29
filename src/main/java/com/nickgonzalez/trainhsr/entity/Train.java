package com.nickgonzalez.trainhsr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "trains")
@Getter
@Setter
public class Train {
    @Id
    @Column(name="id")
    private int id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "route_id")
    private Route route;
    @Column(name="departure_time")
    private Date departure;
    @Column(name="arrival_time")
    private Date arrival;
    @Column(name="current_capacity")
    private int currentCapacity;
    @Column(name="max_capacity")
    private int maxCapacity;
}
