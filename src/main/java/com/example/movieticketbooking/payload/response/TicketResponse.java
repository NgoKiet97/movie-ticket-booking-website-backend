package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TicketResponse {
    private int showMovieId;
    private String movie;
    private String cinema;
    private String room;
    private String date;
    private String startTime;

    private String seat;
    private String guestName;
    private String typeTicket;
    private int billId;
    private String user;

    private String stateTicket;


}
