package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.request.TicketRequest;
import com.example.movieticketbooking.payload.response.TicketResponse;

import java.util.List;

public interface ITicketService {
    List<TicketResponse> getAllTicket();

    boolean addTicket(TicketRequest ticketRequest);
}
