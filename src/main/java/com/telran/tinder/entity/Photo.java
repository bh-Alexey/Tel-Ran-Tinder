package com.telran.tinder.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "photo")
@Data
public class Photo {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String name;

    @ManyToOne
    private User user;
}
