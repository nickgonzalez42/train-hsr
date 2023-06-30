package com.nickgonzalez.trainhsr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "routes")
@Getter
@Setter
@ToString
public class Route {
    @Id
    @Column(name="id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "origin_id")
    private Station origin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destination_id")
    private Station destination;

    @Column(name = "distance")
    private float distance;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<Train> train;

    public Route() {

    }

    public Route(int id, Station origin, Station destination, float distance, List<Train> train) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.train = train;
    }
}
