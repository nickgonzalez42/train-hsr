package com.nickgonzalez.trainhsr.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    private String authority;
    @Id
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "username")
    private User user;
}
