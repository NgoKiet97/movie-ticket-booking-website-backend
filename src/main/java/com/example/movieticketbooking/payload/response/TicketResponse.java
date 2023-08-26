package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TicketResponse {
    private int showMovieId;
    private String seat;
    private String guestName;
    private String typeTicket;
    private int billId;
    private String stateTicket;

}
