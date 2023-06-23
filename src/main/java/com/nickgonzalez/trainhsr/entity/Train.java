package com.nickgonzalez.trainhsr.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Train() {

    }

    public Train(Route route, Date departure, Date arrival, int currentCapacity, int maxCapacity) {
        this.route = route;
        this.departure = departure;
        this.arrival = arrival;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
    }

    public int getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", route=" + route +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", currentCapacity=" + currentCapacity +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
