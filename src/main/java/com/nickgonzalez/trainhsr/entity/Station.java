package com.nickgonzalez.trainhsr.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "stations")
@Getter
@Setter
@ToString
public class Station {
    @Id
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToMany(mappedBy = "origin")
    @JsonIgnore
    private List<Route> outbound;

    @OneToMany(mappedBy = "destination")
    @JsonIgnore
    private List<Route> inbound;

//    pathfinding variables
    @Transient
    @JsonIgnore
    private double g = 0;
    @JsonIgnore
    @Transient
    private double h = 0;
    @Transient
    @JsonIgnore
    private double f = 0;
    @JsonIgnore
    @Transient
    private Station parent = null;
}
