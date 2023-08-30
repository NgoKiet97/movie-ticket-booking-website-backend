package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.*;
import com.example.movieticketbooking.entity.ids.Ticketids;
import com.example.movieticketbooking.payload.request.TicketRequest;
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

    @Override
    public boolean addTicket(TicketRequest ticketRequest) {
        try{
            TicketEntity ticketEntity = new TicketEntity();

            Ticketids ticketids = new Ticketids();
            ticketids.setSeatId(ticketRequest.getSeatId());
            ticketids.setShowMovieId(ticketids.getShowMovieId());
            ticketEntity.setIds(ticketids);

            ShowMovieEntity showMovieEntity = new ShowMovieEntity();
            showMovieEntity.setId(ticketRequest.getShowMovieId());
            ticketEntity.setShowMovie(showMovieEntity);

            SeatEntity seatEntity = new SeatEntity();
            seatEntity.setId(ticketRequest.getSeatId());
            ticketEntity.setSeat(seatEntity);

            ticketEntity.setGuestName(ticketRequest.getGuestName());

            TypeTicketEntity typeTicketEntity = new TypeTicketEntity();
            typeTicketEntity.setId(ticketRequest.getTypeTicketId());
            ticketEntity.setTypeTicket(typeTicketEntity);

            BillEntity billEntity = new BillEntity();
            billEntity.setId(ticketRequest.getBillId());
            ticketEntity.setBill(billEntity);

            StateTicketEntity stateTicketEntity = new StateTicketEntity();
            stateTicketEntity.setId(ticketRequest.getStateTicketId());
            ticketEntity.setStateTicket(stateTicketEntity);

            ticketRepository.save(ticketEntity);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
