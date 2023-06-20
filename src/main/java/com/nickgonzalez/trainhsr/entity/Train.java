package com.nickgonzalez.trainhsr.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private int routeId;
}
