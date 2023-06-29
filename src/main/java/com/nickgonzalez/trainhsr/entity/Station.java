package com.nickgonzalez.trainhsr.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "origin")
    @JsonIgnore
    private List<Route> outbound;

    @OneToMany(mappedBy = "destination")
    @JsonIgnore
    private List<Route> inbound;
}
