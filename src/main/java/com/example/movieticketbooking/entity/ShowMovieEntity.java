package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity(name = "show_movie")
@Getter @Setter
public class ShowMovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "state_show")
    private String stateShow;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @OneToMany(mappedBy = "showMovie")
    private Set<TicketEntity> ticketEntities;

}
