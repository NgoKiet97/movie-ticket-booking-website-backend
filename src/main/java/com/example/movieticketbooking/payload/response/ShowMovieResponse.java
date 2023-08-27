package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ShowMovieResponse {
    private int id;
    private String movie;
    private String cinema;
    private String room;
    private String date;
    private String startTime;
    private String state;
}
