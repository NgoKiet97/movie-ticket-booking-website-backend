package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity(name = "show_movie")
@Getter @Setter
public class ShowMovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "startTime")
    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
}
