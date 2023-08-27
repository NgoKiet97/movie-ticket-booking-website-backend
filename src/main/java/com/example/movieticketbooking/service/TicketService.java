package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.TicketEntity;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.payload.response.TicketResponse;
import com.example.movieticketbooking.repository.TicketRepository;
import com.example.movieticketbooking.service.imp.ITicketService;
import com.example.movieticketbooking.utils.DateHelperUtils;
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
            ticketResponse.setMovie(entity.getShowMovie().getMovie().getName());
            ticketResponse.setCinema(entity.getShowMovie().getRoomEntity().getCinema().getName());
            ticketResponse.setRoom(entity.getShowMovie().getRoomEntity().getName());

            DateHelperUtils dateHelperUtils = new DateHelperUtils();
            ticketResponse.setDate(dateHelperUtils.formatDateToString(entity.getShowMovie().getDate()));

            ticketResponse.setStartTime(entity.getShowMovie().getStartTime().toString());

            ticketResponse.setSeat(entity.getSeat().getName());
            ticketResponse.setGuestName(entity.getGuestName());
            ticketResponse.setTypeTicket(entity.getTypeTicket().getName());
            ticketResponse.setBillId(entity.getBill().getId());
            ticketResponse.setUser(entity.getBill().getUser().getName());
            ticketResponse.setStateTicket(entity.getStateTicket().getName());

            ticketResponseList.add(ticketResponse);
        }

        return ticketResponseList;
    }
}
