package com.example.movieticketbooking.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class ShowMovieRequest {
    private int movieId;
    private int roomId;
    @NotNull
    private String date;

    @NotNull
    private String startTime;

    @NotNull
    private String state;
}
