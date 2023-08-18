package com.example.movieticketbooking.entity.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Ticketids implements Serializable {

    @Column(name = "show_movie_id")
    private int showMovieId;

    @Column(name = "seat_id")
    private int seatId;

}
