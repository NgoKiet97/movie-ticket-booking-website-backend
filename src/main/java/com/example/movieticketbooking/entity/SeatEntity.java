package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "seat")
@Getter @Setter
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
}
