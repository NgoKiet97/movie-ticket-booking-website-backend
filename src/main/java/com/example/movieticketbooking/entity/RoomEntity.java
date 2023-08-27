package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "room")
@Getter @Setter
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaEntity cinema;

    @OneToMany(mappedBy = "room")
    private Set<SeatEntity> seats;

    @OneToMany(mappedBy = "roomEntity")
    private Set<ShowMovieEntity> showMovies;
}
