package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.TypeTicketResponse;

import java.util.List;

public interface ITypeTicketService {
    List<TypeTicketResponse> getAllTypeTicket();
}
