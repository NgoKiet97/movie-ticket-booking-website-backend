package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.StateTicketEntity;
import com.example.movieticketbooking.payload.response.StateTicketResponse;
import com.example.movieticketbooking.repository.StateTicketRepository;
import com.example.movieticketbooking.service.imp.IStateTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateTicketService implements IStateTicketService {
    @Autowired
    StateTicketRepository stateTicketRepository;

    @Override
    public List<StateTicketResponse> getAllStateTicket() {
        List<StateTicketResponse> stateTicketResponseList = new ArrayList<>();
        List<StateTicketEntity> stateTicketEntityList = stateTicketRepository.findAll();

        for(StateTicketEntity entity : stateTicketEntityList){
            StateTicketResponse stateTicketResponse = new StateTicketResponse();
            stateTicketResponse.setId(entity.getId());
            stateTicketResponse.setName(entity.getName());

            stateTicketResponseList.add(stateTicketResponse);
        }

        return stateTicketResponseList;
    }
}
