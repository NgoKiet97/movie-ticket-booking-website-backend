package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.TypeTicketEntity;
import com.example.movieticketbooking.payload.response.TypeTicketResponse;
import com.example.movieticketbooking.repository.TypeTicketRepository;
import com.example.movieticketbooking.service.imp.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeTicketService implements ITypeTicketService {
    @Autowired
    TypeTicketRepository typeTicketRepository;

    @Override
    public List<TypeTicketResponse> getAllTypeTicket() {
        List<TypeTicketEntity> typeTicketEntityList = typeTicketRepository.findAll();
        List<TypeTicketResponse> typeTicketResponseList = new ArrayList<TypeTicketResponse>();

        for(TypeTicketEntity entity : typeTicketEntityList){
            TypeTicketResponse typeTicketResponse = new TypeTicketResponse();
            typeTicketResponse.setId(entity.getId());
            typeTicketResponse.setName(entity.getName());
            typeTicketResponse.setPrice(entity.getTicketPrice());

            typeTicketResponseList.add(typeTicketResponse);
        }
        return typeTicketResponseList;
    }

    @Override
    public TypeTicketResponse getTypeTicketById(int typeId) {
        TypeTicketResponse typeTicketResponse = new TypeTicketResponse();
        Optional<TypeTicketEntity> typeTicket = typeTicketRepository.findById(typeId);
        if (typeTicket.isPresent()){
            typeTicketResponse.setId(typeTicket.get().getId());
            typeTicketResponse.setName(typeTicket.get().getName());
            typeTicketResponse.setPrice(typeTicket.get().getTicketPrice());
        }
        return typeTicketResponse;
    }
}
