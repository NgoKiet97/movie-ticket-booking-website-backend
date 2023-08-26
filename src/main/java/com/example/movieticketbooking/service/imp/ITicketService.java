package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.TicketResponse;

import java.util.List;

public interface ITicketService {
    List<TicketResponse> getAllTicket();
}
