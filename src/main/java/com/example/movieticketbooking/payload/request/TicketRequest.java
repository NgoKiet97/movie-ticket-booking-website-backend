package com.example.movieticketbooking.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class TicketRequest {
    @NotNull
    private int showMovieId;

    @NotNull
    private int seatId;

    private String guestName;

    @NotNull
    private int typeTicketId;

    private int billId;


    private int stateTicketId;
}
