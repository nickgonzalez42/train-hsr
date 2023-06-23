package com.nickgonzalez.trainhsr.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "origin_id")
    private Station origin;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "destination_id")
    private Station destination;
    @Column(name = "distance")
    private float distance;

    public Route() {

    }

    public Route(Station origin, Station destination, float distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public Station getOrigin() {
        return origin;
    }

    public void setOrigin(Station origin) {
        this.origin = origin;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", origin=" + origin +
                ", destination=" + destination +
                ", distance=" + distance +
                '}';
    }
}
