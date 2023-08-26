package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.TicketEntity;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.payload.response.TicketResponse;
import com.example.movieticketbooking.repository.TicketRepository;
import com.example.movieticketbooking.service.imp.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<TicketResponse> getAllTicket() {
        List<TicketEntity> ticketEntityList = ticketRepository.findAll();
        List<TicketResponse> ticketResponseList = new ArrayList<TicketResponse>();

        for(TicketEntity entity : ticketEntityList){
            TicketResponse ticketResponse = new TicketResponse();
            ticketResponse.setShowMovieId(entity.getShowMovie().getId());
            ticketResponse.setSeat(entity.getSeat().getName());
            ticketResponse.setGuestName(entity.getGuestName());
            ticketResponse.setTypeTicket(entity.getTypeTicket().getName());
            ticketResponse.setBillId(entity.getBill().getId());
            ticketResponse.setStateTicket(entity.getStateTicket().getName());

            ticketResponseList.add(ticketResponse);
        }

        return ticketResponseList;
    }
}
