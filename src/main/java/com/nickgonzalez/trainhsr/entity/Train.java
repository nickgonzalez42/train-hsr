package com.nickgonzalez.trainhsr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "trains")
@Getter
@Setter
@ToString
public class Train {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonBackReference
    private Route route;

    @Column(name="departure_time")
    private Date departure;
    @Column(name="arrival_time")
    private Date arrival;
    @Column(name="current_capacity")
    private int currentCapacity;
    @Column(name="max_capacity")
    private int maxCapacity;
    public Train() {

    }
    public Train(Route route, Date departure, Date arrival, int currentCapacity, int maxCapacity) {
        this.route = route;
        this.departure = departure;
        this.arrival = arrival;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
    }
}
